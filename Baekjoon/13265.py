# 색칠하기
import sys
from collections import deque
input = sys.stdin.readline

def bfs(start):
    global ans
    visited[start] = True
    q = deque([start])
    color[start] = 1
    while q:
        x = q.popleft()
        for next in adj[x]:
            if not visited[next]:
                visited[next] = True
                # 다른 색으로 칠하기
                color[next] = -color[x]
                q.append(next)
            # 만약에 다음 노드가 같은 색이라면 impossible
            if visited[next] and color[next] == color[x]:
                ans = "impossible"
                return

t = int(input())
for _ in range(t):
    ans = "possible"
    n, m = map(int, input().split())
    adj = [[] for _ in range(n + 1)]
    color = [0] * (n + 1)
    for _ in range(m):
        a, b = map(int, input().split())
        adj[a].append(b)
        adj[b].append(a)

    visited = [False] * (n + 1)
    for i in range(1, n):
        if not visited[i]:
            bfs(i)
        # 더이상 탐색하지 않음
        if ans == "impossible":
            break
    print(ans)