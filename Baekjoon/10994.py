# 별 찍기 - 19
n = int(input())

def f(cnt=1, base=['*']):   # 1부터 시작, 처음 모양은 *
    # n까지 다 만들었다면 출력 후 return
    if cnt == n:
        for ans in base:
            print(''.join(ans))
        return

    w = len(base[0])  # 현재 base의 가로 길이 측정
    next = []   # 다음 단계의 별 패턴을 저장할 리스트

    outer = '*' * (w + 4)   # 제일 겉단
    inner = '* ' + ' ' * w + ' *'   # 안쪽단

    next.append(outer)
    next.append(inner)

    for b in base:
        next.append('* ' + b + ' *')

    next.append(inner)
    next.append(outer)

    # 재귀 호출
    f(cnt + 1, next)

f()