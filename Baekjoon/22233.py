# 가희와 키워드
import sys
input = sys.stdin.readline
n, m = map(int, input().split())    # 메모장, 블로그
memo = [input().rstrip() for _ in range(n)]
check = {}
for keyword in memo:
    check[keyword] = 1

for _ in range(m):
    blog = input().rstrip().split(',')
    for b in blog:
        if check.get(b, 0):
            n -= 1
            check[b] = 0
    print(n)