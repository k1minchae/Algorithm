import java.io.IOException;
import java.io.*;
import java.util.*;

public class B16953 {
    static long A, B, answer;
    public static void dfs(long num, long cnt) {
        if (num > B) {
            return;
        }
        if (num == B) {
            answer = Math.min(cnt, answer);
        }

        dfs(num * 2, cnt + 1);
        dfs(num * 10 + 1, cnt + 1);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        answer = Integer.MAX_VALUE;
        dfs(A, 0);
        if (answer == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(answer + 1);
        }
    }
}
