import java.io.*;
import java.util.*;

public class B1741 {
    // 팰린드롬인지 확인
    public static boolean isP(int num) {
        int pos = 1; // 자리수
        while (pos <= 7) {
            if (num % Math.pow(10, pos) == num) {
                break;
            }
            pos++;
        }
        int left = pos - 1; // 판별할 왼쪽 위치
        int right = 1;  // 판별할 수의 오른쪽 위치
        while (left >= right) {
            int leftNum = ((int) (num / Math.pow(10, left)) % 10);
            int rightNum = (int) ((int) (num % Math.pow(10, right) - num % Math.pow(10, right - 1)) / Math.pow(10, right - 1));
            if (leftNum == rightNum) {
                left--;
                right++;
                continue;
            }
            return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[] notPrime = new boolean[1003002]; // 소수 판별 (N이 100만 일경우 가장 가까운 정답이 1003001 임)
        notPrime[1] = true;

        // 소수 구해두기
        for (int i=1; i<=Math.pow(1003001, 0.5); i++) {
            // 이미 소수가 아니라면 continue
            if (notPrime[i]) {
                continue;
            }
            for (int j=i+i; j<=1003001; j+=i) {
                notPrime[j] = true;
            }
        }

        for (int i=n; i<1003002; i++) {
            if (!notPrime[i] & isP(i)) {
                System.out.println(i);
                break;
            }
        }
    }
}
