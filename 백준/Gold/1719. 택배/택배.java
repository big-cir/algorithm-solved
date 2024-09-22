import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M;
    static List<List<int[]>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph.get(v1).add(new int[] {v2, cost});
            graph.get(v2).add(new int[] {v1, cost});
        }

        int[][] parents = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            parents[i] = bfs(i);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (parents[i][j] == 0) sb.append("-");
                else sb.append(parents[i][j]);
                sb.append(" ");
            }
            
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static int[] bfs(int start) {
        int[] parent = new int[N + 1];
        int[] dis = new int[N + 1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[start] = 0;

        int[] track = new int[N + 1];

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int[] next : graph.get(now)) {
                int nextVertex = next[0];
                int cost = next[1];

                if (dis[nextVertex] > dis[now] + cost) {
                    dis[nextVertex] = dis[now] + cost;
                    track[nextVertex] = now;
                    queue.offer(nextVertex);
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            if (i == start) continue;

            int cur = i;
            int child = i;
            while (true) {
                int p = track[child];

                if (p == start) {
                    parent[cur] = child;
                    break;
                }

                child = p;
            }
        }

        return parent;
    }
}