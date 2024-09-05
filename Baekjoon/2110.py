# 공유기 설치
import sys
input = sys.stdin.readline

N, C = map(int, input().split())
arr = [int(input()) for _ in range(N)]
arr.sort()

left = 1
right = arr[-1] - arr[0]
ans = 0

while left <= right:
    # print(left, right)
    mid = (left + right) // 2
    cnt = 1
    current = arr[0]
    for i in range(1, N):
        if arr[i] - current >= mid:
            cnt += 1
            current = arr[i]
    if cnt >= C:
        ans = mid
        left = mid + 1
    else:
        right = mid - 1
print(ans)

"""
left, right 설정하는 거랑
cnt 세는 방식이 조금 엇나가서 여러번 틀렸다 ㅠㅠ
이진탐색은 항상 헷갈리는 것 같아서 좀 더 많은 유형의 문제를 접해봐야겠다.
"""