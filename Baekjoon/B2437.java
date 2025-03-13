import java.io.*;
import java.util.*;

public class B2437 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int sum = 0;
        for (int x : arr) {
            // 여태 만들 수 있는 연속된 수보다 크다면 break
            if (x > sum + 1) {
                break;

            // 연속된 수 유지
            } else {
                sum += x;
            }
        }
        System.out.println(sum + 1);
    }
}
