import java.util.*;

class Solution {
    public int solution(int[][] scores) {
        int answer = 1;
        int n = scores.length;
        int[] wan = {scores[0][0], scores[0][1]}; // 완호 점수
        
        Arrays.sort(scores, (a, b) -> {
            // 첫 번째 점수는 내림차순
            if (a[0] != b[0]) {
                return b[0]-a[0];
            }
            else { // 두번째 점수는 오름차순
                return a[1]-b[1];
            }
        });
        
        int maxSecond = 0;
        boolean canReceive = true;
        
        for (int i=0; i<n; i++) {
            // 탈락
            if (maxSecond > scores[i][1]) {
                // 완호 탈락
                if (wan[0] == scores[i][0] && wan[1] == scores[i][1]) {
                    canReceive = false;
                    break;
                }
                continue;
            }

            // 두번째 점수 갱신
            maxSecond = Math.max(scores[i][1], maxSecond);
            
            // 완호보다 윗 석차일 경우 등수 늘리기
            if (wan[0] + wan[1] < scores[i][0] + scores[i][1]) {
                answer++;
            }
        }
        
        // 완호가 못받는경우
        if (!canReceive) {
            answer = -1;
        }
        
        return answer;
    }
}