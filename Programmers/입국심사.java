import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long right = (long) times[times.length - 1] * n;
        long left = times[0];
        
        // 이분탐색
        long answer = right;
        while (left < right) {
            long mid = (left + right) / 2;
            long people = 0;
            for (int i=0; i<times.length; i++) {
                people += mid / times[i];
            }
            if (people < n) {
                left = mid + 1;
            } else {
                answer = Math.min(answer, mid);
                right = mid;
            }
        }
        return answer;
    }
}