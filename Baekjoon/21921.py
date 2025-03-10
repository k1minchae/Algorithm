# 블로그
import sys
input = sys.stdin.readline

n, x = map(int, input().split())
arr = list(map(int, input().split()))

ans = sum(arr[:x])  # 방문자수의 합: 초기값 설정
cnt = 1 # 최대 방문자 수가 나온 횟수 (초기값: 1)

right = x   # 구간을 나타내는 오른쪽 포인터
now_sum = ans   # 현재 x일 동안의 방문자 합

while right < n:
    now_sum -= arr[right - x]   # 이전 구간의 첫 번째 원소 제거
    now_sum += arr[right]   # 새로운 원소 추가

    # 기존 최대 방문자 수와 동일한 경우
    if ans == now_sum:
        cnt += 1    # 같은 최대값이 나온 횟수 증가

    # 더 큰 방문자 수가 나온 경우
    elif ans < now_sum:
        cnt = 1 # 새로운 최대값이므로 횟수 초기화
        ans = now_sum   # 최대 방문자 수 업데이트
    
    # 오른쪽 포인터 이동
    right += 1

if not ans:
    print("SAD")
else:
    print(ans)
    print(cnt)
