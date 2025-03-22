# 얼음깨기 펭귄
import sys
from collections import deque
input = sys.stdin.readline
n, s, p = map(int, input().split()) # 얼음개수, 지지대개수, 펭귄위치
adj = [[] for _ in range(n + 1)]
for _ in range(n-1):
    a, b = map(int, input().split())
    adj[a].append(b)
    adj[b].append(a)

visited = [0] * (n + 1)
visited[p] = 1
q = deque([p])
while q:
    x = q.popleft()
    for next in adj[x]:
        if not visited[next]:
            visited[next] = visited[x] + 1
            q.append(next)
sorted_visited = sorted(visited[1:s+1])
print(n - sorted_visited[0] - sorted_visited[1] + 1)