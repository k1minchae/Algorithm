import java.io.*;
import java.util.*;

public class B15661 {
    static int[][] arr;
    static int n, ans;

    public static void btc(int idx, int s, int l, int start, int link) {
        if (idx == n - 1) {
            ans = Math.min(ans, Math.abs(s - l));
            return;
        }
        int ns = s;
        int nl = l;
        for (int i=0; i<=idx; i++) {
            if ((start << i) != 0) {
                ns += arr[i][idx+1];
                ns += arr[idx+1][i];
            }
            if ((link << i) != 0) {
                nl += arr[i][idx+1];
                nl += arr[i][idx+1];
            }
        }
        btc(idx+1, ns, l, start << (idx + 1), link);
        btc(idx+1, s, nl, start, link << (idx + 1));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        ans = Integer.MAX_VALUE;
        arr = new int[n][n];
        for (int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j=0; j<n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        btc(0, 0, 0, 1, 0);
        btc(0, 0, 0, 0, 1);

        System.out.println(ans);
    }
}
