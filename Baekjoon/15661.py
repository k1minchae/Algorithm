# 링크와 스타트
import sys
input = sys.stdin.readline
n = int(input())
arr = [list(map(int, input().split())) for _ in range(n)]
answer = float('inf')

def back_trc(idx, start_score, link_score, start, link):
    global answer
    if idx == n:
        if start > 0 and link > 0:
            answer = min(answer, abs(start_score - link_score))
        return

    ns = start_score
    for i in range(n):
        if start & 1<<i:
            ns += arr[i][idx] + arr[idx][i]
    back_trc(idx + 1, ns, link_score, start | (1<<idx), link)

    nl = link_score
    for i in range(n):
        if link & 1<<i:
            nl += arr[i][idx] + arr[idx][i]
    back_trc(idx + 1, start_score, nl, start, link | (1<<idx))

back_trc(1, 0, 0, 1, 0)
back_trc(1, 0, 0, 0, 1)
print(answer)