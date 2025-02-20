import java.io.*;
import java.util.*;

public class B14938 {
    public static int n, m, r, answer;
    public static int[] arr, visited;
    public static ArrayList<ArrayList<Node>> adj;

    public static class Node implements Comparable<Node> {
        int node;
        int len;

        Node(int node, int len) {
            this.node = node;
            this.len = len;
        }

        @Override
        public int compareTo(Node o) {
            return this.len - o.len;    // 오름 차순 정렬
        }
    }
    
    public static void dijkstra(int start) {
        int sumVal = 0;
        
        // 최대 값으로 초기화
        visited = new int[n];
        for (int i=0; i<n; i++) {
            visited[i] = Integer.MAX_VALUE;
        }
        
        // 우선 순위 큐에 시작 좌표 넣기
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            if (visited[node.node] < node.len | node.len > m) {
                continue;
            }
            // 방문 표시
            visited[node.node] = node.node;
            
            // 연결 된 다음 노드 탐색
            for (Node next : adj.get(node.node)) {
                int nextLen = node.len + next.len;
                if (nextLen <= m & visited[next.node] >= nextLen) {
                    pq.add(new Node(next.node, node.len + next.len));
                }
            }
        }
        
        // 탐색 종료 후 획득 가능한 아이템 체크
        for (int i=0; i<n; i++) {
            if (visited[i] != Integer.MAX_VALUE) {
                sumVal += arr[i];
            }
        }
        answer = Math.max(answer, sumVal);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        answer = 0;
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        // 아이템 가치
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 인접 리스트
        adj = new ArrayList<>();
        for (int i=0; i<n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i=0; i<r; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            adj.get(a - 1).add(new Node(b - 1, l));
            adj.get(b - 1).add(new Node(a - 1, l));
        }
        
        // 모든 노드에 대해 최소 경로 탐색
        for (int i=0; i<n; i++) {
            dijkstra(i);
        }

        System.out.println(answer);
    }
}
