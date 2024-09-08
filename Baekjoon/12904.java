import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static boolean dfs(String now, String target) {
        // ���� ����: now�� target�� ������ ����
        if (now.equals(target)) {
            return true;
        }
        
        // ���� ���ڿ��� ��ǥ ���ڿ����� ª���� �� �̻� Ž������ ����
        if (now.length() < target.length()) {
            return false;
        }

        // ���� 1: ���ڿ��� A�� ������ ���
        if (now.charAt(now.length() - 1) == 'A') {
            if (dfs(now.substring(0, now.length() - 1), target)) {
                return true;
            }
        }

        // ���� 2: ���ڿ��� B�� ������ ��� (������ ���� �� B�� ����)
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
        
        // ������ DFS�� ���� �ذ�
        // ������ ���ڿ� ���� ������ ������ �ٿ������� ���� ȿ�����̰� ������ �� ����.
        if (dfs(T, S)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}
