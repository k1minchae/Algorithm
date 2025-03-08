# 오델로
import sys
input = sys.stdin.readline
n = int(input())
game = [tuple(map(int, input().split())) for _ in range(n)]

arr = [['.'] * 6 for _ in range(6)]
arr[2][2] = 'W'; arr[3][3] = 'W'; arr[2][3] = 'B'; arr[3][2] = 'B'
dir = ((-1, 0), (1, 0), (0, -1), (0, 1), (-1, -1), (-1, 1), (1, -1), (1, 1))    # 8방향
is_b = True # 선은 흑돌
b = 0
w = 0
for y, x in game:
    if is_b:
        arr[y-1][x-1] = 'B'
        b += 1
    else:
        arr[y-1][x-1] = 'W'
        w += 1
    for dy, dx in dir:
        ny = y + dy - 1
        nx = x + dx - 1
        temp = []
        while 0 <= ny < 6 and 0 <= nx < 6 and arr[ny][nx] != '.':
            # 다른 색 돌을 만났다면
            if arr[ny][nx] != arr[y-1][x-1]:
                temp.append((ny, nx))

            # 내돌을 만났다면
            else:
                # 뒤집기
                while temp:
                    ty, tx = temp.pop()
                    arr[ty][tx] = arr[y-1][x-1]
                    if is_b:
                        b += 1
                        w -= 1
                    else:
                        w += 1
                        b -= 1
                break
            ny += dy
            nx += dx
    is_b = not is_b
for a in arr:
    print(''.join(a))
if b > w:
    print("Black")
else:
    print("White")