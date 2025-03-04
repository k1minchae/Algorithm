import sys
from collections import deque

input = sys.stdin.readline

# 입력 받기
n = int(input())
arr = list(map(int, input().split()))

dq = deque((i + 1, arr[i]) for i in range(n))  # (풍선 인덱스 + 1, 적힌 숫자)

ans = []  # 결과 저장

# 첫 번째 풍선 터뜨리기
idx, num = dq.popleft()
ans.append(idx)

# 풍선이 남아 있는 동안 반복
while dq:
    if num > 0:  # 오른쪽 이동
        dq.rotate(-(num - 1))  # x-1 만큼 왼쪽으로 회전
    else:  # 왼쪽 이동
        dq.rotate(-num)  # x 만큼 오른쪽으로 회전

    idx, num = dq.popleft()  # 새로운 풍선 터뜨리기
    ans.append(idx)

# 결과 출력
print(*ans)

'''
deque.rotate는 배열을 회전시킬 때 배열전체를 수정하지 않고 
내부적으로 최적화 된 방식으로 동작함.
회전 시킨 만큼만 연산을 수행한다 => rotate(k) 의 시간 복잡도는 O(k)
'''