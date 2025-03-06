# 0 만들기
import sys
input = sys.stdin.readline
t = int(input())
ans = [[] for _ in range(10)]
not_num = ['+', '-', ' ']

# 백트래킹 함수
def btc(temp, cnt, n):
    # 완료 조건
    if cnt == n:
        # 결과 값이 0일때만 정답 배열에 추가
        if check_zero(temp):
            ans[n].append(''.join(temp))
        return
    
    # 백트래킹
    temp[2 * cnt - 1] = ' '
    btc(temp, cnt + 1, n)
    temp[2 * cnt - 1] = '+'
    btc(temp, cnt + 1, n)
    temp[2 * cnt - 1] = '-'
    btc(temp, cnt + 1, n)

# 결과값이 0인지 체크하는 함수
def check_zero(arr):
    res = 0
    is_plus = True
    before = int(arr[0])
    for x in range(1, len(arr)):
        # 숫자가 아닐 때
        if arr[x] in not_num:
            # 공백일땐 따로 처리하고 skip
            if arr[x] == ' ':
                before *= 10
                continue
            
            # 이전에 저장해둔 숫자 털기
            if is_plus:
                res += before
            else:
                res -= before
            before = 0
            
            # 최근 연산자 업데이트
            if arr[x] == '+':
                is_plus = True
            if arr[x] == '-':
                is_plus = False
            continue
            
        # 숫자일 땐 before 변수에 저장해두기
        before += int(arr[x])
    
    # 마지막 숫자 계산
    if is_plus:
        res += before
    else:
        res -= before

    # 결과값이 0일때 True
    if res == 0:
        return True
    return False

for _ in range(t):
    n = int(input())

    # 이전에 연산하지 않은 n이라면 연산 수행
    if not ans[n]:
        temp = []
        for i in range(1, n+1):
            temp.append(str(i))
            if i != n:
                temp.append('')
        btc(temp, 1, n)
    
    # 정답 출력
    print(*ans[n], sep='\n')
    print()