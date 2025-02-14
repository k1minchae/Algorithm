# 백준: 과일 탕후루
import sys
input = sys.stdin.readline

n = int(input())
arr = list(map(int, input().split()))

left = 0
right = 0
answer = 1

fruits = [0] * 10
fruits[arr[0]] += 1

while 0 <= left <= right and right < n - 1:
    f = arr[right + 1]
    fruits[f] += 1

    # 과일 종류 카운트
    cnt = 0
    for i in range(1, 10):
        if fruits[i]:
            cnt += 1
        # 종류가 2개 넘는다면 break
        if cnt > 2:
            break

    # 2개 넘지 않았을 때 실행
    else:
        right += 1
        answer = max(answer, right - left + 1)
        continue

    # 종류가 2개 넘는다면 실행
    rf = arr[left]
    fruits[rf] -= 1
    left += 1
    fruits[f] -= 1

print(answer)
# print(fruits)
# print("왼: ", left)
# print("오른: ", right)