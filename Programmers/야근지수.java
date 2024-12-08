import java.util.*;

class Solution {
    
    public long solution(int n, int[] works) {
        // 작업 시간이 큰 수 부터 뽑아내는 우선순위 큐
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int work : works) {
            pq.add(work);
        }
        
        // 퇴근까지 작업시간이 긴 업무부터 하기
        while (n > 0 && pq.size() > 0) {
            int work = pq.poll();
            work--;
            if (work > 0) {
                pq.add(work);
            }
            n--;
        }
        
        // 남은 잔업 정답에 제곱하여 더해주기
        long answer = 0;
        while (pq.size() > 0) {
            int temp = pq.poll();
            answer += temp * temp;
        }
        
        return answer;
    }
}