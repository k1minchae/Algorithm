import java.io.*;
import java.util.*;

public class B18110 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        if (n == 0) {
            System.out.println(0);
        }
        else {
            int removeCnt = (int) Math.round(n * 0.15);
            Arrays.sort(arr);
            int sumVal = 0;
            for (int i=removeCnt; i<n-removeCnt; i++) {
                sumVal += arr[i];
            }
            // int 타입끼리 연산하면 무조건 int 타입만 나옴 (소숫점 벼러짐)
            // sumVal 을 float 으로 변환한 뒤 연산 -> round함수 사용 
            System.out.println(Math.round((float) sumVal / (n - removeCnt * 2)));
        }
    }
}
