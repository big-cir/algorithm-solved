import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M;
    static List<List<Node>> list;

    static class Node {
        int v;
        int cost;

        public Node(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        list = new ArrayList<>();
        for (int i = 0; i <= N; i++) list.add(new ArrayList<>());

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            list.get(v1).add(new Node(v2, cost));
            list.get(v2).add(new Node(v1, cost));
        }

        int[][] chs = new int[N + 1][N + 1];
        int[][] dis = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                bfs(i, j, dis, chs);
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            System.out.println(dis[v1][v2]);
        }
    }

    private static void bfs(int v1, int v2, int[][] dis, int[][] chs) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(v1, 0));
        chs[v1][v1] = 1;

        while (!queue.isEmpty()) {
            Node now = queue.poll();

            for (Node next : list.get(now.v)) {
                if (chs[v1][next.v] == 0) {
                    chs[v1][next.v] = 1;
                    dis[v1][next.v] += next.cost + dis[v1][now.v];
                    queue.offer(next);
                }
            }
        }
    }
}
