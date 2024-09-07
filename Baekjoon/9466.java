import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] visited; 
    static int cycleNode;

    public static void dfs(int[] arr, int node, ArrayList<Integer> cycleList, HashMap<Integer, Integer> cycleIdx, int depth) {
        visited[node] = 1;
        cycleList.add(node); // 싸이클 후보 리스트에 추가
        int next = arr[node];
        cycleIdx.put(node, depth); // 싸이클 후보리스트 중 현재 노드의 순서(idx) 저장

        if (visited[next] == 1) { // 이미 방문한 노드
            if (cycleIdx.containsKey(next)) { // 싸이클 O
                // 싸이클 발견, 싸이클 시작점을 기록
                cycleNode = cycleIdx.get(next);
            }
        } else if (visited[next] == 0) { // 방문하지 않은 경우에만 DFS
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
            int answer = N; // 팀에 속하지 않은 사람의 수

            for (int i = 1; i <= N; i++) {
                if (visited[i] == 0) {
                    ArrayList<Integer> cycleList = new ArrayList<>();
                    HashMap<Integer, Integer> cycleIdx = new HashMap<>();
                    cycleNode = -1; // 싸이클이 발생하지 않았음을 의미

                    dfs(array, i, cycleList, cycleIdx, 0);

                    // 싸이클이 발생한 경우 처리
                    if (cycleNode != -1) {
                        answer -= (cycleList.size() - cycleNode); // 싸이클 크기만큼 빼기
                    }
                }
            }
            System.out.println(answer);
        }
    }
}
