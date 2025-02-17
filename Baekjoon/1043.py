# 백준: 거짓말
import sys
from collections import deque
input = sys.stdin.readline

n, m = map(int, input().split()) # 사람수, 파티수
t, *true_knows = map(int, input().split()) # 진실을 아는 사람

adj = [[0] * (n + 1) for _ in range(n + 1)]
knows = [0] * (n + 1)
q = deque([])
for true_know in true_knows:
    q.append(true_know)
    knows[true_know] = 1

parties = []
for _ in range(m):
    p, *party = list(map(int, input().split())) # 파티에 오는 사람들
    for i in range(p):
        for j in range(p):
            if i == j:
                continue
            adj[party[i]][party[j]] = 1
    parties.append(party)

# 진실을 아는 사람이 없을 경우
if t == 0:
    print(m)
else:
    while q:
        node = q.popleft()
        for i in range(1, n + 1):
            if adj[node][i] and not knows[i]:
                knows[i] = 1
                q.append(i)

    for party in parties:
        for p in party:
            if knows[p]:
                m -= 1
                break
    print(m)