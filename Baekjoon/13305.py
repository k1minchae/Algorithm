# 주유소
import sys
input = sys.stdin.readline
n = int(input())
length = list(map(int, input().split()))
price = list(map(int, input().split()))
ans = length[0] * price[0]

before = price[0]
for i in range(1, n-1):
    if price[i] > before:
        ans += (length[i] * before)
    else:
        ans += (length[i] * price[i])
        before = price[i]
print(ans)