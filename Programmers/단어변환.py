from collections import deque

def solution(begin, target, words):
    visited = {}
    for word in words:
        visited[word] = 0
        
    # 타겟을 만들 수 없는 경우
    if visited.get(target, -1) == -1:
        return 0
    
    # 첫 시작점 방문 표시
    visited[begin] = 1

    # BFS
    q = deque([begin])
    while q:
        curr = q.popleft() # 현재 기준점 단어
        
        if curr == target: # 원하는 단어를 찾았을 경우 break
            break
        
        # 단어 배열에서 비교
        for word in words:
            diff_cnt = 0
            for i in range(len(curr)):
                if diff_cnt > 1: # 다른 부분이 1개보다 많을 경우 탐색 중단
                    break
                if word[i] != curr[i]:
                    diff_cnt += 1
            # 다른 부분이 1개 초과거나 이미 방문한 단어일 경우 탐색 중단
            if diff_cnt > 1 or visited.get(word, 0):
                continue
            # 경로 계산 및 방문표시 후 큐에 추가
            visited[word] = visited[curr] + 1
            q.append(word)
            
    return visited[target] - 1