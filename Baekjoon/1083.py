# 백준: 소트
import sys
from collections import deque
input = sys.stdin.readline

n = int(input())
arr = list(map(int, input().split()))
s = int(input())

for i in range(n):
    if s == 0:
        break

    max_idx = i
    for j in range(i + 1, min(n, i + s + 1)):
        if arr[j] > arr[max_idx]:
            max_idx = j
    
    # 변화가 없었다면
    if max_idx == i:
        continue
    
    # 횟수 차감
    s -= (max_idx - i)
    max_val = arr.pop(max_idx)
    arr.insert(i, max_val)  # 최댓값을 앞으로 이동
    
print(*arr)