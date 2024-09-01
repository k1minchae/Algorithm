import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc=0; tc<T; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			int[] dp = new int[N+1];
			dp[1] = 1;
			for (int i=2; i<N+1; i++) {
				int divideTo3 = i / 3; // 3으로 나눴을 때 몫
				int additionalVal = 0; // 이전 숫자에서 더해야 할 값
				
				// 짝수라면
				if (i % 2 == 0) {
					// 모두 2로 이루어진 case 추가
					additionalVal += 1; 
						
				// 홀수라면
				} else {
					// 3으로 나눴을 때 몫이 홀수라면
					if (divideTo3 % 2 == 1) {
						// 홀수가 하나 더 많으므로 1 추가
						additionalVal += 1;
					}
				}
				// 3 또는 3과 2로 이루어진 case 추가
				int temp = divideTo3 / 2;
				additionalVal += temp;
				dp[i] = dp[i-1] + additionalVal;
			}
			System.out.println(dp[N]);
		}
	}
}