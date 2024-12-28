class Solution {
    public static int[][] visitedRed;
    public static int[][] visitedBlue;
    public static int answer, n, m;
    
public void dfs(int[] red, int[] blue, int[] goalRed, int[] goalBlue, int cnt, int[][] arr) {
    // 퍼즐이 풀림
    if (red[0] == goalRed[0] && red[1] == goalRed[1] 
        && blue[0] == goalBlue[0] && blue[1] == goalBlue[1]) {
        answer = Math.min(answer, cnt);
        return;
    }

    int[] dy = {-1, 1, 0, 0};
    int[] dx = {0, 0, -1, 1};

    for (int r = 0; r < 4; r++) {
        int nyR = red[0];
        int nxR = red[1];
        if (!(red[0] == goalRed[0] && red[1] == goalRed[1])) { // 레드가 목표에 도착하지 않은 경우만 이동
            nyR = red[0] + dy[r];
            nxR = red[1] + dx[r];

            // Red의 이동 유효성 체크
            if (nyR < 0 || nyR >= n || nxR < 0 || nxR >= m || arr[nyR][nxR] == 5 || visitedRed[nyR][nxR] == 1) {
                continue;
            }
        }

        for (int b = 0; b < 4; b++) {
            int nyB = blue[0];
            int nxB = blue[1];
            if (!(blue[0] == goalBlue[0] && blue[1] == goalBlue[1])) { // 블루가 목표에 도착하지 않은 경우만 이동
                nyB = blue[0] + dy[b];
                nxB = blue[1] + dx[b];

                // Blue의 이동 유효성 체크
                if (nyB < 0 || nyB >= n || nxB < 0 || nxB >= m || arr[nyB][nxB] == 5 || visitedBlue[nyB][nxB] == 1) {
                    continue;
                }
            }

            // 교차 방지
            if (nyB == red[0] && nxB == red[1] && nyR == blue[0] && nxR == blue[1]) {
                continue;
            }
            
            // 같은 위치로 이동 방지
            if (nyB == nyR && nxB == nxR) {
                continue;
            }

            // 새로운 상태 설정
            int[] nRed = {nyR, nxR};
            int[] nBlue = {nyB, nxB};

            // 방문 처리
            visitedRed[nyR][nxR] = 1;
            visitedBlue[nyB][nxB] = 1;

            // DFS 호출
            dfs(nRed, nBlue, goalRed, goalBlue, cnt + 1, arr);

            // 방문 해제
            visitedRed[nyR][nxR] = 0;
            visitedBlue[nyB][nxB] = 0;
        }
    }
}
    
    public int solution(int[][] maze) {
        n = maze.length;
        m = maze[0].length;
        visitedRed = new int[n][m];
        visitedBlue = new int[n][m];
        
        answer = Integer.MAX_VALUE;
        
        int[] goalRed = new int[2]; // y, x
        int[] goalBlue = new int[2];
        int[] startRed = new int[2];
        int[] startBlue = new int[2];
        
        // 좌표 저장
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                if (maze[i][j] == 1) {
                    startRed[0] = i;
                    startRed[1] = j;
                    visitedRed[i][j] = 1;
                } else if (maze[i][j] == 2) {
                    startBlue[0] = i;
                    startBlue[1] = j;
                    visitedBlue[i][j] = 1;
                } else if (maze[i][j] == 3) {
                    goalRed[0] = i;
                    goalRed[1] = j;
                } else if (maze[i][j] == 4) {
                    goalBlue[0] = i;
                    goalBlue[1] = j;
                }
            }
        }
        
        dfs(startRed, startBlue, goalRed, goalBlue, 1, maze);
        
        if (answer == Integer.MAX_VALUE) {
            answer = 1;
        }
        return answer - 1;
    }
}