# 백준: 덩치
import sys
input = sys.stdin.readline

n = int(input())
arr = []
answer = [0] * n
for _ in range(n):
    x, y = map(int, input().split())
    arr.append((x, y))

for i in range(n):
    mx, my = arr[i]
    rank = 1
    for j in range(n):
        yx, yy = arr[j]
        if i == j:
            continue
        if yx > mx and yy > my:
            rank += 1
    answer[i] = rank

print(*answer)