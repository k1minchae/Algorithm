import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B9466 {
    static int[] visited; 
    static int cycleNode;

    public static void dfs(int[] arr, int node, ArrayList<Integer> cycleList, HashMap<Integer, Integer> cycleIdx, int depth) {
        visited[node] = 1;
        cycleList.add(node); // ����Ŭ �ĺ� ����Ʈ�� �߰�
        int next = arr[node];
        cycleIdx.put(node, depth); // ����Ŭ �ĺ�����Ʈ �� ���� ����� ����(idx) ����

        if (visited[next] == 1) { // �̹� �湮�� ���
            if (cycleIdx.containsKey(next)) { // ����Ŭ O
                // ����Ŭ �߰�, ����Ŭ �������� ���
                cycleNode = cycleIdx.get(next);
            }
        } else if (visited[next] == 0) { // �湮���� ���� ��쿡�� DFS
            dfs(arr, next, cycleList, cycleIdx, depth + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            int N = Integer.parseInt(br.readLine());
            int[] array = new int[N + 1]; 

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                array[i] = Integer.parseInt(st.nextToken());
            }

            visited = new int[N + 1];
            int answer = N; // ���� ������ ���� ����� ��

            for (int i = 1; i <= N; i++) {
                if (visited[i] == 0) {
                    ArrayList<Integer> cycleList = new ArrayList<>();
                    HashMap<Integer, Integer> cycleIdx = new HashMap<>();
                    cycleNode = -1; // ����Ŭ�� �߻����� �ʾ����� �ǹ�

                    dfs(array, i, cycleList, cycleIdx, 0);

                    // ����Ŭ�� �߻��� ��� ó��
                    if (cycleNode != -1) {
                        answer -= (cycleList.size() - cycleNode); // ����Ŭ ũ�⸸ŭ ����
                    }
                }
            }
            System.out.println(answer);
        }
    }
}
