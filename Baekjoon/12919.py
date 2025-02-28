# A와 B 2
import sys
from collections import deque

input = sys.stdin.readline
S = list(input().rstrip())
T = deque(list(input().rstrip()))
answer = 0

def remove_str(q):
    global answer
    # 가지 치기
    if len(q) < len(S):
        return
    if len(q) == len(S):
        if all (q[i] == S[i] for i in range(len(q))):
            answer = 1
        return
    if q[-1] == 'A':
        q.pop()
        remove_str(q)
        q.append('A')

    if q[0] == 'B':
        q.popleft()
        q.reverse()
        remove_str(q)
        q.reverse()
        q.appendleft('B')

remove_str(T)
print(answer)