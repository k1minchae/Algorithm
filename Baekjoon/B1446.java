import java.io.*;
import java.util.*;

public class B1446 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		
		HashMap<Integer, HashMap<Integer, Integer>> fastRoad = new HashMap<>();
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			int fastD = Integer.parseInt(st.nextToken());
			
			if (E > D) {
				continue;
			}
			
			if (fastRoad.get(S) == null) {
				HashMap<Integer, Integer> destination = new HashMap<>();
				destination.put(E, fastD);
				fastRoad.put(S, destination);
			} else {
				HashMap<Integer, Integer> destination = fastRoad.get(S);
				if (destination.get(E) != null) {
					destination.put(E, Math.min(fastD, destination.get(E)));
					fastRoad.put(S, destination);
				} else {
					destination.put(E, fastD);
					fastRoad.put(S, destination);
				}
			}
		}

		int[] dp = new int[10001];
		for (int i=0; i<10001; i++) {
			if (i != 0) {
				if (dp[i] == 0) {
					dp[i] = dp[i-1] + 1;
				} else {
					dp[i] = Math.min(dp[i], dp[i-1] + 1);
				}
			}
			
			// ����ġ���� �� �� �ִ� �������� �ִ� ���
			if (fastRoad.get(i) != null) {
				for (int end: fastRoad.get(i).keySet()) {
					// ���� �� ���� �湮�� �� ����
					if (dp[end] == 0) {
						dp[end] = Math.min(end, dp[i] + fastRoad.get(i).get(end));
					} else { // �湮�� �� ����
						dp[end] = Math.min(dp[end], dp[i] + fastRoad.get(i).get(end));
					}
				}
			}

		}
		System.out.println(dp[D]);
	}
}