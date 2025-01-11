# 백준: 크게 만들기
import sys
input = sys.stdin.readline

n, k = map(int, input().split()) # n자리 숫자 x에서 숫자 k개를 지운다
x = list(map(int, input().rstrip()))
answer = [x[0]]
cnt = k
for i in range(1, n):
    # answer 배열에 원소가 있어야 하고, 지울수 있는 횟수가 있어야 하고 정답에 있는 원소가 더 작을 경우 지워야 함
    while answer and cnt > 0 and answer[-1] < x[i]:
        answer.pop()
        cnt -= 1
    answer.append(x[i])

for i in range(n-k):
    print(answer[i], end='')