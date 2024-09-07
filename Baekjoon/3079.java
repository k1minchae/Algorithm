import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		long[] arr = new long[N];
		long left = Long.MAX_VALUE;
		long right = 0;
		
		for (int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			left = Math.min(left, arr[i]);
			right = Math.max(right, arr[i]);
		}
		
		Arrays.sort(arr);
		// 최대값: 가장 오래걸리는 심사관한테 M명이 전부 심사받음
		right *= M; 
		
		long res = 0;
		while (left <= right) {
			// mid값: 가능한 모든 시간대 중 최적의 시간 탐색
			long mid = (left + right) / 2;
			long cnt = 0;
			for (int i=0; i<N; i++) {
				// mid 시간동안 i 번 심사대에서 몇명 받을 수 있는지 더해줌
				cnt += (mid / arr[i]);
				// 가능하다면 더이상 확인하지 않음
				if (cnt > M) {
					break;
				}
			}
			// 가능하지 않다면 숫자 키우기
			if (cnt < M) {
				left = mid + 1;
			}
			else {
				// 가능하다면 숫자 줄이기
				right = mid - 1;
				res = mid;
			}
		}
		System.out.println(res);
	}
}