# 카잉 달력
import sys
import math
input = sys.stdin.readline
t = int(input())
for _ in range(t):
    m, n, x, y = map(int, input().split())

    if x == y:
        print(x)
        continue

    # 최소 공배수 구하기
    end_year = math.lcm(m, n)

    a = min(m, n) # 작은수
    b = max(m, n) # 큰수
    A, B = 0, 0
    if m == a:
        A = x
        B = y
    else:
        A = y
        B = x

    # 작은 수의 배수 만큼 키워 가며 년도가 맞는지 확인
    year = a + A
    result = -1
    while year <= end_year:
        if year % b == 0 and B == b:
            result = year
            break
        if year % b == B:
            result = year
            break
        year += a

    print(result)

