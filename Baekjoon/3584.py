# 가장 가까운 공통 조상
import sys
sys.setrecursionlimit(10**8)
input = sys.stdin.readline

def dfs(node):
    if parents[node]:
        next = parents[node]
        if visited[next] == 1:
            print(next)
            return
        visited[next] = 1
        dfs(next)

t = int(input())
for _ in range(t):
    n = int(input())
    parents = [0] * (n + 1)
    visited = [0] * (n + 1)
    for _ in range(n - 1):
        a, b = map(int, input().split())
        parents[b] = a

    x, y = map(int, input().split())
    visited[x] = 1
    visited[y] = 1

    dfs(x)
    dfs(y)