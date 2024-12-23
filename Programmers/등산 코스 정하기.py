from heapq import heappop, heappush

def solution(n, paths, gates, summits): # 지점수, 등산로, 출입구목록, 산봉우리 목록 (나머지는 쉼터)
    # 산봉우리
    summit = [0] * (n + 1)
    for goal in summits:
        summit[goal] = 1
        
    # 출입구
    gate = [0] * (n + 1)
    for g in gates:
        gate[g] = 1
    
    # 인접리스트
    adj = [[] for _ in range(n + 1)]
    for a, b, time in paths:
        adj[a].append((b, time))
        adj[b].append((a, time))
    
    # 산봉우리까지 최소 경로 찾기
    visited = [float('inf')] * (n + 1)    
    q = []
    for g in gates:
        heappush(q, (0, g))
    
    # 반환할 정답 리스트
    answer = [0, 10 ** 8]
    
    # 다익스트라로 최소 경로 찾기
    while q:
        intensity, node = heappop(q)
        
        # 최소 경로가 아닐 경우 탐색 중단
        if visited[node] <= intensity:
            continue
        # 방문 표시
        visited[node] = intensity
        
        # 산봉우리에 도착한 경우
        if summit[node]:
            if (intensity < answer[1]) or (intensity == answer[1] and node < answer[0]):
                answer[0] = node
                answer[1] = intensity
            continue
            
        # 다음 노드 탐색
        for next, time in adj[node]:
            # 방문 가능하고 다른 출입구가 아닐 경우 탐색 가능
            if visited[next] > intensity and not gate[next]:
                heappush(q, (max(intensity, time), next))
    
    return answer