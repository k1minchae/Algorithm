# 약수의 합
import sys
input = sys.stdin.readline
t = int(input())
f = [i for i in range(1000001)]

for i in range(2, int(1000000 ** 0.5)):
    for j in range(i + i, 1000001, i):
        f[j] += i

print(f[:11])