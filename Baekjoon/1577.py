# 백준: 도로의 개수
import sys
from collections import deque
input = sys.stdin.readline

n, m = map(int, input().split())
k = int(input())

# 고장난 도로
broken_road = [[{} for _ in range(m + 1)] for _ in range(n + 1)]
for _ in range(k):
    a, b, c, d = map(int, input().split())
    broken_road[a][b][(c, d)] = 1
    broken_road[c][d][(a, b)] = 1

# dp[i][j] : i번째 도시에서 j번째 도시까지 갈 수 있는 최소 비용
dp = [[0] * (m + 1) for _ in range(n + 1)]

# 아래, 오른쪽으로만 갈 수 있음
dir = [(1, 0), (0, 1)]


q = deque([(0, 0)])
while q:
    y, x = q.popleft()
    
    # 학교에 이미 도착한 좌표일 경우
    if y == n and x == m:
        continue

    for dy, dx in dir:
        ny = dy + y
        nx = dx + x
        
        # 범위 밖일경우
        if 0 > ny or 0 > nx or ny > n or nx > m:
            continue

        # 망가진 도로일 경우
        if broken_road[y][x].get((ny, nx), -1) != -1:
            continue
        
        # 첫 방문한 곳일 경우
        if not dp[ny][nx]:
            q.append((ny, nx)) # 큐에 추가

        # dp 업데이트
        if dp[y][x] == 0:
            dp[ny][nx] += 1
        else:
            dp[ny][nx] += dp[y][x]

print(dp[n][m])