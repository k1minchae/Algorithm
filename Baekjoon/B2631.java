import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2631 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[][] dp = new int[N+1][N+1];

        // 오름차순으로 정렬할 수 있는 가장 큰 연속횟수를 구하면 됨.
        for (int i=1; i<=N; i++) {
            for (int j=1; j<=N; j++) {
                int num = arr[i - 1];
                // 현재 값보다 작은 경우
                if (j < num) {
                    dp[i][j] = dp[i - 1][j];

                // 현재 값과 같은 경우
                } else if (j == num) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1] + 1);

                // 현재 값보다 큰 경우
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        System.out.println(N - dp[N][N]);
    }
}
