import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, answer, count;
    static int[] ch;
    static int[][] dis;
    static List<List<Integer>> graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken()) - 1;
            int v2 = Integer.parseInt(st.nextToken()) - 1;
            graph.get(v1).add(v2);
            graph.get(v2).add(v1);
        }
        
        
        dis = new int[N][N];
        answer = 0;
        int tmp = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            ch = new int[N];
            ch[i] = 1;
            if (bfs(i) < tmp) {
                tmp = bfs(i);
                answer = i;
            }
        }
        System.out.println(answer + 1);
    }

    public static int bfs(int v1) {
        LinkedList<Integer> pq = new LinkedList<>();
        count = 0;
        pq.add(v1);

        while (!pq.isEmpty()) {
            int cur = pq.poll();
            for (int nx : graph.get(cur)) {
                if (ch[nx] == 0) {
                    ch[nx] = 1;
                    pq.add(nx);
                    dis[v1][nx] = dis[v1][cur] + 1;
                }
            }
        }

        for (int x : dis[v1]) {
            count += x;
        }
        return count;
    }
}
