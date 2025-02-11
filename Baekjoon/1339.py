# 백준: 단어 수학
import sys
input = sys.stdin.readline
n = int(input())
alpha = {}
dict = {}
max_len = 0
for i in range(n):
    word = input().rstrip()
    for j in range(len(word)):
        pos = len(word) - j # 자릿수
        apb = word[j] # 알파벳
        temp = dict.get(pos, {})
        temp[apb] = temp.get(apb, 0) + 1
        dict[pos] = temp
        max_len = max(max_len, len(word))
        alpha[apb] = 0

for idx in range(max_len, 0, -1):
    for k, v in dict[idx].items():
        alpha[k] = alpha.get(k, 0) + 10 ** (idx -1) * v

priority = list(alpha.items())

# 2번째 원소를 기준으로 정렬 (우선순위 높은순)
priority.sort(key = lambda x: x[1], reverse=True)

answer = 0
num = 9
for key, value in priority:
    answer += value * num
    num -= 1
print(answer)