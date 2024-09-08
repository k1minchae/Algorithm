import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static boolean dfs(String now, String target) {
        // 기저 조건: now가 target과 같으면 성공
        if (now.equals(target)) {
            return true;
        }
        
        // 현재 문자열이 목표 문자열보다 짧으면 더 이상 탐색하지 않음
        if (now.length() < target.length()) {
            return false;
        }

        // 연산 1: 문자열이 A로 끝나는 경우
        if (now.charAt(now.length() - 1) == 'A') {
            if (dfs(now.substring(0, now.length() - 1), target)) {
                return true;
            }
        }

        // 연산 2: 문자열이 B로 끝나는 경우 (뒤집기 연산 후 B를 제거)
        if (now.charAt(now.length() - 1) == 'B') {
            StringBuilder sb = new StringBuilder(now.substring(0, now.length() - 1));
            sb.reverse();
            if (dfs(sb.toString(), target)) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        String T = br.readLine();
        
        // 역방향 DFS를 통해 해결
        // 마지막 문자에 따라 가능한 연산을 줄여나가며 보다 효율적이게 연산할 수 있음.
        if (dfs(T, S)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}
