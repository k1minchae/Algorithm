# 한 줄로 서기
import sys
input = sys.stdin.readline
n = int(input())
arr = list(map(int, input().split()))
result = [0] * n

for i in range(n):
    num = i + 1 # 현재 사람이 줄 서는 번호 (1부터 시작)
    bigger_cnt = arr[i] # 왼쪽에 있어야 하는 키큰 사람의 수
    cnt = 0 # 현재까지 빈자리의 수
    for j in range(n):
        if not result[j]:   # 빈자리인경우
            if bigger_cnt == cnt:   # 현재 빈 자리의 개수가 요구조건과 같다면
                result[j] = num # 배치
                break   # 루프 종료
            cnt += 1    # 빈자리 카운트 + 1
print(*result)