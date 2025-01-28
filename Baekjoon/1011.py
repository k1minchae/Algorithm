# Fly me to the Alpha Centauri

t = int(input())
for _ in range(t):
    x, y = map(int, input().split())
    d = y - x  # 두 지점 사이의 거리

    # 이동 횟수가 3번 이하일 때
    if d <= 4:
        if d == 1:
            print(1)
        elif d == 2:
            print(2)
        else:
            print(3)
        continue
    
    # 처음 시작을 4번 부터
    ans = 4
    before = 4 # 이동 3번일때 최대값
    max_distance = 2 # 이동한 거리중 최대값
    while True:
        now = before
        if ans % 2 == 1: # 홀수일 때는 최대값을 늘린다
            max_distance += 1
        now += max_distance

        # 정답을 찾았을 때 break
        if now >= d > before:
            print(ans)
            break
        # 아직 정답을 못 찾았다면 횟수 늘리기
        ans += 1
        before = now
