import sys
input = sys.stdin.readline

# 입력 받기
a, b, c = map(int, input().split())
A = sorted(map(int, input().split()))
B = sorted(map(int, input().split()))
C = sorted(map(int, input().split()))

ans = float('inf')

def find_closest(arr, x):
    left, right = 0, len(arr) - 1
    while left <= right:
        mid = (left + right) // 2
        if arr[mid] < x:
            left = mid + 1
        else:
            right = mid - 1
    if 0 <= left < len(arr) and abs(x - arr[left]) <  abs(x - arr[right]):
        return arr[left]
    return arr[right]

# `A`의 각 원소에 대해 가장 가까운 `B`와 `C`를 찾기
for aa in A:
    # `B`에서 `aa`와 가장 가까운 값 찾기
    bb = find_closest(B, aa)
    # `C`에서 `aa`, `bb`와 가장 가까운 값 찾기
    cc = find_closest(C, (aa + bb) // 2)

    # 최소 벌점 갱신
    ans = min(ans, max(aa, bb, cc) - min(aa, bb, cc))

print(ans)
