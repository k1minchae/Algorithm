# 햄버거 분배
import sys
input = sys.stdin.readline
n, k = map(int, input().split())
s = input().rstrip()
ans = 0
visited = [0] * n
for i in range(n):
    x = s[i]
    if x == 'H':
        for j in range(max(0, i-k), min(n, i+k+1)):
            if s[j] == 'P' and not visited[j]:
                visited[j] = 1
                ans += 1
                break

print(ans)