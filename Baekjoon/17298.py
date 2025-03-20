# 오큰수
import sys
input = sys.stdin.readline
n = int(input())
arr = list(map(int, input().split()))

stack = []
ans = [0] * n
for i in range(n-1, -1, -1):
    x = arr[i]
    while stack and stack[-1] <= x:
        stack.pop()
    if stack:
        ans[i] = stack[-1]
    else:
        ans[i] = -1
    stack.append(x)
print(*ans)
