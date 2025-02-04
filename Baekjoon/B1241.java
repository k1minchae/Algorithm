import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

// 1241: 머리 톡톡
class B1241 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        HashMap<Integer, Integer> students = new HashMap<>();
        int[] numbers = new int[N];
        for (int i=0; i<N; i++) {
            int x = Integer.parseInt(br.readLine());
            numbers[i] = x;
            students.put(x, students.getOrDefault(x, 0) + 1);
        }

        StringBuilder sb = new StringBuilder();

        // 각 입력값에 대한 약수를 구한다.
        for (int x : numbers) {
            int answer = 0;

            for (int i=1; i*i<=x; i++) {
                if (x % i == 0) {
                    answer += students.getOrDefault(i, 0);
                    if (i != x / i) {
                        answer += students.getOrDefault(x/i, 0);
                    }
                }
            }
            sb.append(answer - 1);
            sb.append("\n");
        }
        System.out.println(sb);
    }
}