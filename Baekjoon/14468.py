import sys
input = sys.stdin.readline().rstrip()

stack = []  # 소들이 지나가는 경로를 저장하는 스택
visited = {}  # 각 소의 방문 여부를 기록하는 딕셔너리
ans = 0  # 소들이 만난 횟수

# 입력된 소의 이동 경로를 하나씩 확인
for x in input:  # x: 현재 소
    # 이미 도착한 소라면 (즉, 두 번째 등장하는 경우)
    if visited.get(x, 0):
        temp = []  # 일시적으로 pop한 소들을 저장할 리스트

        # 스택의 맨 위에 있는 소가 현재 소(x)와 같아질 때까지 반복
        while stack[-1] != x:
            ans += 1  # 다른 소와 만났으므로 만남 횟수 증가
            t = stack.pop()  # 다른 소를 스택에서 제거
            temp.append(t)  # 제거한 소를 임시 배열에 저장

        stack.pop()  # 현재 소(x)를 스택에서 제거 (자신도 도착했으므로)
        visited[x] = 0  # 현재 소의 방문 상태를 초기화

        # 스택에서 잠시 제거한 소들을 다시 원래 순서대로 추가
        stack.extend(reversed(temp))
        continue

    # 현재 소가 처음 등장한 경우
    stack.append(x)  # 스택에 추가
    visited[x] = 1  # 방문 여부를 기록

# 최종적으로 만난 횟수 출력
print(ans)
