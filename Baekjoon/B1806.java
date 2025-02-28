import java.io.*;
import java.util.*;

// 백준 : 부분합
public class B1806 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        // 투 포인터
        int left = 0;
        int right = 0;
        long sumVal = arr[0];
        int answer = Integer.MAX_VALUE;
        while (right < n & left <= right) {
            if (sumVal >= s) {
                answer = Math.min(answer, right - left + 1);
                sumVal -= arr[left];
                left += 1;
            }
            else {
                right += 1;
                if (right < n) {
                    sumVal += arr[right];
                }
            }
        }
        System.out.println(answer == Integer.MAX_VALUE ? 0 : answer);
    }
}
