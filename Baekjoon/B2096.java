import java.io.*;
import java.util.*;

public class B2096 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][3];
        int[][] dpMax = new int[N][3];
        int[][] dpMin = new int[N][3];
        for (int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
        }

        for (int i=0; i<3; i++) {
            dpMax[0][i] = arr[0][i];
            dpMin[0][i] = arr[0][i];
        }

        for (int i=1; i<N; i++) {
            dpMax[i][0] = Math.max(dpMax[i - 1][0], dpMax[i - 1][1]) + arr[i][0];
            dpMax[i][1] = Math.max(Math.max(dpMax[i - 1][0], dpMax[i - 1][1]), dpMax[i - 1][2]) + arr[i][1];
            dpMax[i][2] = Math.max(dpMax[i - 1][1], dpMax[i - 1][2]) + arr[i][2];

            dpMin[i][0] = Math.min(dpMin[i - 1][0], dpMin[i - 1][1]) + arr[i][0];
            dpMin[i][1] = Math.min(Math.min(dpMin[i - 1][0], dpMin[i - 1][1]), dpMin[i - 1][2]) + arr[i][1];
            dpMin[i][2] = Math.min(dpMin[i - 1][1], dpMin[i - 1][2]) + arr[i][2];
        }

        StringBuilder sb = new StringBuilder();
        int maxVal = Math.max(dpMax[N - 1][0], Math.max(dpMax[N - 1][1], dpMax[N - 1][2]));
        int minVal = Math.min(dpMin[N - 1][0], Math.min(dpMin[N - 1][1], dpMin[N - 1][2]));

        sb.append(maxVal);
        sb.append(" ");
        sb.append(minVal);

        System.out.println(sb);
    }
}
