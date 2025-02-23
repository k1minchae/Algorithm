# 프린터 큐
import sys
from collections import deque
input = sys.stdin.readline
t = int(input())
for _ in range(t):
    n, m = map(int, input().split())
    arr = list(map(int, input().split()))

    q = deque([])
    for idx, num in enumerate(arr):
        q.append((num, idx))
    cnt = 1
    while q:
        num, idx = q.popleft()
        if any (other[0] > num for other in q):
            q.append((num, idx))
            continue
        if num == arr[m] and m == idx:
            break
        cnt += 1

    print(cnt)