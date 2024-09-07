import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	// val과 같거나 더 큰 것 중 가장 왼쪽에 있는 idx를 반환한다 (lowBound)
	static int lowBound(int[] array, int val) {
		int low = 0;
		int high = array.length;
		
		while (low < high) {
			int mid = (low + high) / 2;
			if (array[mid] < val) {
				low = mid + 1;
			} else {
				high = mid;
			}
		}
		return low;
	}
	
	// val보다 큰 것 중 가장 왼쪽에 있는 idx를 반환한다 (upperBound)
	static int upperBound(int[] array, int val) {
		int low = 0;
		int high = array.length;
		while (low < high) {
			int mid = (low + high) / 2;
			if (array[mid] <= val) {
				low = mid + 1;
			} else {
				high = mid;
			}
		}
		return low;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 동굴 길이
		int H = Integer.parseInt(st.nextToken()); // 동굴 높이
		
		int[] bottom = new int[N/2]; // 석순 배열
		int[] top = new int[N/2]; // 종유석 배열
		
		for (int i = 0; i < N; i++) {
			if (i % 2 == 0) { // 석순
				bottom[i / 2] = Integer.parseInt(br.readLine());
			} else { // 종유석
				top[(i - 1) / 2] = Integer.parseInt(br.readLine());
			}
		}
		
		// 석순과 종유석을 정렬
		Arrays.sort(bottom);
		Arrays.sort(top);
		
		int res = N; // 최소 부딪히는 장애물 수
		int cnt = 1; // 최소 장애물이 발생하는 구간의 수
		
		for (int h = 1; h <= H; h++) {
			// 석순: 높이 h에서 h 이상인 석순을 구함
			int temp = N / 2 - lowBound(bottom, h) + N / 2 - lowBound(top, H - h + 1);
			
			// 최소값을 갱신
			if (res > temp) {
				res = temp;
				cnt = 1;
			} else if (res == temp) {
				cnt++;
			}
		}
		System.out.println(res + " " + cnt);
	}
}
