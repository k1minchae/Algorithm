import sys
from collections import deque

input = sys.stdin.readline

r, c, t = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(r)]

dir = [(-1, 0), (0, 1), (1, 0), (0, -1)]  # 상우하좌 (시계 방향)

# 공기청정기 위치 찾기
cleaner = []
for i in range(r):
    if arr[i][0] == -1:
        cleaner.append(i)

upper_cleaner, lower_cleaner = cleaner[0], cleaner[1]

def spread_dust():
    """미세먼지를 확산하는 함수"""
    global arr
    arr_copy = [[0] * c for _ in range(r)]
    arr_copy[upper_cleaner][0] = -1  # 공기청정기 위치 유지
    arr_copy[lower_cleaner][0] = -1  

    for y in range(r):
        for x in range(c):
            if arr[y][x] > 0:  # 먼지가 있는 경우
                spread_amount = arr[y][x] // 5
                spread_count = 0

                for dy, dx in dir:  # 4방향 확산
                    ny, nx = y + dy, x + dx
                    if 0 <= ny < r and 0 <= nx < c and arr[ny][nx] != -1:
                        arr_copy[ny][nx] += spread_amount
                        spread_count += 1

                arr_copy[y][x] += arr[y][x] - (spread_amount * spread_count)

    arr = arr_copy

def clean_air():
    """공기청정기 작동"""
    # 위쪽 공기청정기: 반시계 방향
    y, x = upper_cleaner, 1
    prev = 0
    for dy, dx in [(0,1), (-1,0), (0,-1), (1,0)]:  # 반시계 방향
        while True:
            ny, nx = y + dy, x + dx
            if ny < 0 or ny > upper_cleaner or nx < 0 or nx >= c:
                break
            arr[y][x], prev = prev, arr[y][x]
            y, x = ny, nx

    # 아래쪽 공기청정기: 시계 방향
    y, x = lower_cleaner, 1
    prev = 0
    for dy, dx in [(0,1), (1,0), (0,-1), (-1,0)]:  # 시계 방향
        while True:
            ny, nx = y + dy, x + dx
            if ny < lower_cleaner or ny >= r or nx < 0 or nx >= c:
                break
            arr[y][x], prev = prev, arr[y][x]
            y, x = ny, nx

# 실행
for _ in range(t):
    spread_dust()
    clean_air()

# 남아있는 미세먼지 합계 구하기
answer = sum(sum(row) for row in arr) + 2  # 공기청정기(-1 두 개) 제외
print(answer)
