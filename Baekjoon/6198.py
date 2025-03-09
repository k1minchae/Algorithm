# 옥상 정원 꾸미기
import sys
input = sys.stdin.readline
n = int(input())
arr = [int(input()) for _ in range(n)]
result = [0] * n

while arr:

    now = len(arr) - 1  # 현재 빌딩 인덱스
    nex = now - 1   # 다음 빌딩 인덱스
    x = arr.pop()

    # 다음 빌딩에서 현재 빌딩을 볼 수 없다면 한 칸 더 가기
    while nex >= 0 and arr[nex] <= x:
        nex -= 1

    # 볼수 있게 됐다면 현재 빌딩에서 보던것 + 1 해주기
    if nex >= 0 and arr[nex] > x:
        result[nex] += (result[now] + 1)

print(sum(result))
# print(result)