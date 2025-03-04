# 요세푸스 문제 0
import sys
input = sys.stdin.readline
n, k = map(int, input().split())

arr = [str(i) for i in range(1, n + 1)]

result = []
idx = 0
while arr:
    idx = (idx + k - 1) % len(arr)
    x = arr.pop(idx)
    result.append(x)

print("<" + ", ".join(result) + ">")
