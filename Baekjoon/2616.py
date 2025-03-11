# 소형기관차
import sys
input = sys.stdin.readline
n = int(input())
arr = list(map(int, input().split()))
k = int(input())
ans = 0

dp = [[0] * n for _ in range(4)]
dp[1][k - 1] = sum(arr[:k])

# 첫번째 기차는 구간의 합으로 구하기
for i in range(k, n):
    dp[1][i] = dp[1][i - 1] - arr[i - k] + arr[i]

# 2번째 기차는 k만큼 전에 있는 것중에 제일 좋은 걸로 선택
max_v = 0
for i in range(2 * k - 1, n):
    if dp[1][i-k] > max_v:
        max_v = dp[1][i-k]
    dp[2][i] = max_v + dp[1][i]
print(dp)
# 3번째 기차는 역순
max_v = dp[1][-1]
for i in range(n-1-k, 0, -1):
    # 첫번째 기차(누적합) 해둔것 중 제일 좋은 걸로 선택
    if dp[1][i+k] > max_v:
        max_v = dp[1][i+k]
    dp[3][i] = max_v + dp[2][i]
    ans = max(ans, dp[3][i])

print(ans)
print(dp)
