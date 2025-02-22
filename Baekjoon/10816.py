import sys
input = sys.stdin.readline
n = int(input())
arr = list(map(int, input().split()))
m = int(input())
target = list(map(int, input().split()))
cnt = {}
for num in arr:
    cnt[num] = cnt.get(num, 0) + 1
answer = [0] * m
for i in range(m):
    answer[i] = cnt.get(target[i], 0)
print(*answer)


