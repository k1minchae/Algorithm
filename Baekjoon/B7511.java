import java.io.*;
import java.util.*;

public class B7511 {
    static int[] parents;
    public static int find(int x) {
        if (parents[x] == x) {
            return x;
        }
        return parents[x] = find(parents[x]);
    }

    public static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x == y) {
            return;
        }
        parents[y] = x;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int tc=1; tc<=t; tc++) {
            sb.append("Scenario ");
            sb.append(tc);
            sb.append(":\n");
            int n = Integer.parseInt(br.readLine());
            int k = Integer.parseInt(br.readLine());
            parents = new int[n];
            for (int i=0; i<n; i++) {
                parents[i] = i;
            }

            for (int i=0; i<k; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                union(a, b);
            }
            int m = Integer.parseInt(br.readLine());
            for (int i=0; i<m; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                if (find(u) == find(v)) {
                    sb.append("1\n");
                }
                else {
                    sb.append("0\n");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
