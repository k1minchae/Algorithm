# 전쟁 - 전투
'''
전쟁은 어느덧 전면전이 시작되었다. 결국 전투는 난전이 되었고,
우리 병사와 적국 병사가 섞여 싸우게 되었다. 그러나 당신의 병사들은 흰색 옷을 입고,
적국의 병사들은 파란색 옷을 입었기 때문에 서로가 적인지 아군인지는 구분할 수 있다.
문제는 같은 팀의 병사들은 모이면 모일수록 강해진다는 사실이다.

N명이 뭉쳐있을 때는 N^2의 위력을 낼 수 있다.
과연 지금 난전의 상황에서는 누가 승리할 것인가?
단, 같은 팀의 병사들이 대각선으로만 인접한 경우는 뭉쳐 있다고 보지 않는다.

'''

import sys
from collections import deque

def bfs(sy, sx):
    q = deque([(sy, sx)])
    visited[sy][sx] = 1
    color = arr[sy][sx]
    cnt = 1
    while q:
        y, x = q.popleft()
        for dy, dx in dir:
            ny = y + dy
            nx = x + dx
            if 0 <= ny < n and 0 <= nx < m and arr[ny][nx] == color and not visited[ny][nx]:
                visited[ny][nx] = 1
                cnt += 1
                q.append((ny, nx))
    return cnt

input = sys.stdin.readline
m, n = map(int, input().split())
arr = [list(input().rstrip()) for _ in range(n)]
visited = [[0] * m for _ in range(n)]
dir = [(-1, 0), (1, 0), (0, -1), (0, 1)]
white = 0
black = 0
for i in range(n):
    for j in range(m):
        if not visited[i][j]:
            if arr[i][j] == 'W':
                white += bfs(i, j) ** 2
            else:
                black += bfs(i, j) ** 2
print(white, black)