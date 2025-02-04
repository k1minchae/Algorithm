import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B3020 {
	// val�� ���ų� �� ū �� �� ���� ���ʿ� �ִ� idx�� ��ȯ�Ѵ� (lowBound)
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
	
	// val���� ū �� �� ���� ���ʿ� �ִ� idx�� ��ȯ�Ѵ� (upperBound)
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
		int N = Integer.parseInt(st.nextToken()); // ���� ����
		int H = Integer.parseInt(st.nextToken()); // ���� ����
		
		int[] bottom = new int[N/2]; // ���� �迭
		int[] top = new int[N/2]; // ������ �迭
		
		for (int i = 0; i < N; i++) {
			if (i % 2 == 0) { // ����
				bottom[i / 2] = Integer.parseInt(br.readLine());
			} else { // ������
				top[(i - 1) / 2] = Integer.parseInt(br.readLine());
			}
		}
		
		// ������ �������� ����
		Arrays.sort(bottom);
		Arrays.sort(top);
		
		int res = N; // �ּ� �ε����� ��ֹ� ��
		int cnt = 1; // �ּ� ��ֹ��� �߻��ϴ� ������ ��
		
		for (int h = 1; h <= H; h++) {
			// ����: ���� h���� h �̻��� ������ ����
			int temp = N / 2 - lowBound(bottom, h) + N / 2 - lowBound(top, H - h + 1);
			
			// �ּҰ��� ����
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
