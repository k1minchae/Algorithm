import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준: 색칠1
public class B1117 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long W = Long.parseLong(st.nextToken());
        long H = Long.parseLong(st.nextToken());
        long f = Long.parseLong(st.nextToken());
        long c = Long.parseLong(st.nextToken());
        long x1 = Long.parseLong(st.nextToken());
        long y1 = Long.parseLong(st.nextToken());
        long x2 = Long.parseLong(st.nextToken());
        long y2 = Long.parseLong(st.nextToken());

        // 가로 겹쳐진 부분 계산
        long j = 0;

        // 1. 가로로 겹쳐진 부분이 없을 때
        if (f == 0 || W == f) {
            j = 0;
        }

        // 2. 오른쪽 너비를 초과하지 않을때
        else if (W - f > f) {
            j = f;
        }

        else if (W - f <= f) {
            j = W - f;
        }

        // 겹쳐진 부분중 색칠된 부분 계산
        long color = 0;

        // 1. 색칠 범위가 겹친 부분에 속할 때
        if (x1 < j) {
            if (x2 < j) {
                color = x2 - x1;
            } else {
                color = j - x1;
            }
        }

        // 색칠 된 부분 중 안 겹쳐진 부분 계산
        long k = (color > 0) ? x2 - x1 - color : x2 - x1;

        // 세로로 접은 것 계산
        long answer = (color * 2 + k) * (c + 1) * (y2 - y1);
        System.out.println(W * H - answer);
        // System.out.println(j);
        // System.out.println(color);
    }
}
