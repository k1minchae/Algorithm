# 어린 왕자
import sys
input = sys.stdin.readline
t = int(input())
for _ in range(t):
    sx, sy, ex, ey = map(int, input().split())
    n = int(input())
    cnt = 0
    for _ in range(n):
        cx, cy, r = map(int, input().split())
        start_d = ((cx - sx) ** 2 + (cy - sy) ** 2) ** 0.5
        end_d = ((cx - ex) ** 2 + (cy - ey) ** 2) ** 0.5

        # 시작과 끝이 전부 외부에 있음
        if start_d > r and end_d > r:
            continue

        # 시작과 끝이 전부 내부에 있음
        if start_d < r and end_d < r:
            continue
        cnt += 1
    print(cnt)