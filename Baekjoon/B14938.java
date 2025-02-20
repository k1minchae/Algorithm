import java.io.*;
import java.util.*;

public class B14938 {
    public static int n, m, r, answer;
    public static int[] arr, visited;
    public static ArrayList<ArrayList<Rode>> adj;

    public static class Rode implements Comparable<Rode> {
        int end;
        int len;

        Rode(int end, int len) {
            this.len = len;
            this.end = end;
        }

        @Override
        public int compareTo(Rode o) {
            return this.len - o.len;    // 오름 차순 정렬 
        }
    }
    
    public static void dijkstra(int start) {
        int sumVal = arr[start];
        visited = new int[n];
        for (int i=0; i<n; i++) {
            visited[i] = Integer.MAX_VALUE;
        }

        PriorityQueue<Rode> pq = new PriorityQueue<>();
        pq.add(new Rode(start, 0));

        while (!pq.isEmpty()) {
            Rode node = pq.poll();
            if (visited[node.end] < node.len | node.len > m) {
                continue;
            }
            visited[node.end] = node.end;

            for (Rode next : adj.get(node.end)) {
                if (node.len + next.len <= m) {
                    pq.add(new Rode(next.end, node.len + next.len));
                }
            }
            for (int i=0; i<n; i++) {
                if (visited[i] != Integer.MAX_VALUE) {
                    sumVal += arr[i];
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<n; i++) {
            sb.append(visited[i]);
            sb.append(", ");
        }
        System.out.println(sb);
        answer = Math.max(answer, sumVal);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        answer = 0;
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        adj = new ArrayList<>();
        for (int i=0; i<n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i=0; i<r; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            adj.get(a - 1).add(new Rode(b - 1, l));
            adj.get(b - 1).add(new Rode(a - 1, l));
        }

        for (int i=0; i<n; i++) {
            dijkstra(i);
        }

        System.out.println(answer);
    }
}
