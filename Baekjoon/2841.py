# 외계인의 기타 연주
import sys
input = sys.stdin.readline
n, p = map(int, input().split())
arr = []
for _ in range(n):
    string, p = map(int, input().split())
    arr.append((string, p))
guitar = [[] for _ in range(7)]
cnt = 0
for s, p in arr:
    # 손가락 뗄 필요 없을 때까지 떼기
    while guitar[s] and guitar[s][-1] > p:
        guitar[s].pop()
        cnt += 1

    # 프렛을 누를 필요 X
    if guitar[s] and guitar[s][-1] == p:
        continue
    
    # 프렛 누르기
    if not guitar[s] or guitar[s][-1] < p:
        guitar[s].append(p)
        cnt += 1

print(cnt)