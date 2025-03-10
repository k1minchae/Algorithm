# 동전 1
import sys
input = sys.stdin.readline
n, k = map(int, input().split())
arr = [int(input()) for _ in range(n)]
arr.sort()
dp = [0] * (k + 1)
dp[0] = 1

for coin in arr:
    for next in range(coin, k + 1):
        dp[next] += dp[next - coin]
        
print(dp[-1])