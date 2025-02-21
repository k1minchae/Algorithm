// 백준 : 가장 긴 바이토닉 부분 수열 (11054)
import java.io.*;
import java.util.*;

public class B11054 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] dp1 = new int[n]; // 앞에서 부터
        int[] dp2 = new int[n]; // 뒤에서 부터

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());

            // 각각 자기 자신을 고른 값(1)이 최소
            dp1[i] = 1;
            dp2[i] = 1;
        }

        // i 보다 작은 j 값은 i를 갱신할 수 있음 (j + 1을 하는 경우와 i를 비교 해서 갱신)
        for (int i=1; i<n; i++) {
            for (int j=0; j<i; j++) {
                if (arr[i] > arr[j]) {
                    dp1[i] = Math.max(dp1[i], dp1[j] + 1);
                }
            }
        }

        // 맨 뒤에서 부터 같은 방식으로 수행 
        for (int i=n-2; i>=0; i--) {
            for (int j=n-1; j>i; j--) {
                if (arr[i] > arr[j]) {
                    dp2[i] = Math.max(dp2[i], dp2[j] + 1);
                }
            }
        }

        // 더한 값을 비교해서 최대값 갱신
        int answer = 0;
        for (int i=0; i<n; i++) {
            answer = Math.max(answer, dp1[i] + dp2[i] - 1);
        }
        System.out.println(answer);
    }
}
