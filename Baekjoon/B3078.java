import java.io.*;
import java.util.*;

public class B3078 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 학생 수
        int k = Integer.parseInt(st.nextToken()); // 친구 거리 제한

        int[] arr = new int[n]; // 이름 길이 저장
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine().length();
        }

        ArrayDeque<Integer> q = new ArrayDeque<>(); // 윈도우 관리 큐
        int[] check = new int[21]; // 이름 길이 카운팅 (최대 20글자)

        long ans = 0;

        for (int i = 0; i < n; i++) {
            // 새로운 학생 추가 전에 같은 길이를 가진 학생 수를 정답에 추가
            // arr[i]가 들어오면, 이전 K범위 내에서 같은 이름 길이를 가진 학생들과 좋은 친구 쌍을 형성할 수 있음.
            ans += check[arr[i]];

            // 현재 학생 추가
            q.add(arr[i]);
            check[arr[i]]++;

            // 윈도우 크기가 K 초과하면 맨 앞 학생 제거
            if (q.size() > k) {
                int removed = q.poll();
                check[removed]--;
            }
        }

        System.out.println(ans);
    }
}
