import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        // 소수 미리 찾아두기
        int[] sosu = new int[10000];
        int m = (int) Math.pow(9999, 0.5);
        for (int i = 2; i <= m; i++) {
            if (sosu[i] == 1) { // 소수가 아닌 것 표시
                continue;
            }
            for (int num = i * 2; num <= 9999; num += i) {
                sosu[num] = 1; // i의 배수는 소수가 아님을 표시
            }
        }
        for (int tc=0; tc<T; tc++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	int A = Integer.parseInt(st.nextToken());
        	int B = Integer.parseInt(st.nextToken());
        	
        	int[] visited = new int[10000];
        	ArrayDeque<Integer> q = new ArrayDeque<>();
        	visited[A] = 1;
        	q.add(A);
        	
        	boolean isFind = false;
        	while (!q.isEmpty()) {
        		int curr = q.poll();
        		if (curr == B) {
        			System.out.println(visited[B] - 1);
        			isFind = true;
        			break;
        		}
        		for (int i=0; i<=9; i++) {
        			// 1의자리 변환
        			int one = curr / 10 * 10 + i;
        			if (one != curr && sosu[one] == 0 && visited[one] == 0) {
        				q.add(one);
        				visited[one] = visited[curr] + 1;
        			}
        			
        			// 10의 자리 변환
        			int ten = curr / 100 * 100 + i * 10 + curr % 10;
        			if (ten != curr && sosu[ten] == 0 && visited[ten] == 0) {
        				q.add(ten);
        				visited[ten] = visited[curr] + 1;
        			}
        			
        			// 100의 자리 변환
        			int baek = curr / 1000 * 1000 + i * 100 + curr % 100;
        			if (baek != curr && sosu[baek] == 0 && visited[baek] == 0) {
        				q.add(baek);
        				visited[baek] = visited[curr] + 1;
        			}
        			
        			// 1000의 자리 변환
        			int chun = i * 1000 + curr % 1000;
        			if (chun > 1000 && chun != curr && sosu[chun] == 0 && visited[chun] == 0) {
        				q.add(chun);
        				visited[chun] = visited[curr] + 1;
        			}
        		}
        	}
        	// 탐색 실패시 Impossible 출력
        	if (isFind == false) {
        		System.out.println("Impossible");
        	}
        }
    }
}
