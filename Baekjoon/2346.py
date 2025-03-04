# 풍선 터뜨리기
import sys
input = sys.stdin.readline
n = int(input())
arr = list(map(int, input().split()))
idx = 0
dir = 0 # 1: 오른쪽, (n-1): 왼쪽
ans = [1]
x = arr[idx % n]
arr[0] = 0

b = 1
while b < n:
    cnt = 1
    if x > 0:
        dir = 1
    elif x < 0:
        dir = n - 1
    while b < n and cnt <= abs(x):
        next = (idx + cnt * dir) % n
        if arr[next]:
            if cnt == abs(x):
                x = arr[next]
                idx = next
                arr[next] = 0
                ans.append(next + 1)
                b += 1
                break
            cnt += 1
        else:
            idx += dir
print(*ans)