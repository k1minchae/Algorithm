import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B3079 {
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
		// �ִ밪: ���� �����ɸ��� �ɻ������ M���� ���� �ɻ����
		right *= M; 
		
		long res = 0;
		while (left <= right) {
			// mid��: ������ ��� �ð��� �� ������ �ð� Ž��
			long mid = (left + right) / 2;
			long cnt = 0;
			for (int i=0; i<N; i++) {
				// mid �ð����� i �� �ɻ�뿡�� ��� ���� �� �ִ��� ������
				cnt += (mid / arr[i]);
				// �����ϴٸ� ���̻� Ȯ������ ����
				if (cnt > M) {
					break;
				}
			}
			// �������� �ʴٸ� ���� Ű���
			if (cnt < M) {
				left = mid + 1;
			}
			else {
				// �����ϴٸ� ���� ���̱�
				right = mid - 1;
				res = mid;
			}
		}
		System.out.println(res);
	}
}