import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B15989 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc=0; tc<T; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			int[] dp = new int[N+1];
			dp[1] = 1;
			for (int i=2; i<N+1; i++) {
				int divideTo3 = i / 3; // 3���� ������ �� ��
				int additionalVal = 0; // ���� ���ڿ��� ���ؾ� �� ��
				
				// ¦�����
				if (i % 2 == 0) {
					// ��� 2�� �̷���� case �߰�
					additionalVal += 1; 
						
				// Ȧ�����
				} else {
					// 3���� ������ �� ���� Ȧ�����
					if (divideTo3 % 2 == 1) {
						// Ȧ���� �ϳ� �� �����Ƿ� 1 �߰�
						additionalVal += 1;
					}
				}
				// 3 �Ǵ� 3�� 2�� �̷���� case �߰�
				int temp = divideTo3 / 2;
				additionalVal += temp;
				dp[i] = dp[i-1] + additionalVal;
			}
			System.out.println(dp[N]);
		}
	}
}