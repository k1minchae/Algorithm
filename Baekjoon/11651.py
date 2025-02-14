# 좌표 정렬하기 2
import sys
input = sys.stdin.readline

n = int(input())
arr = []
for _ in range(n):
    a, b = map(int, input().split())
    arr.append((a, b))

# y좌표 기준으로 정렬
arr.sort(key = lambda x: (x[1], x[0]))

for x, y in arr:
    print(x, y)