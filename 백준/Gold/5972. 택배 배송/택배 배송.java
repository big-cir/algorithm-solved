import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static int[] dis;
    static List<List<Graph>> graphs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dis = new int[N + 1];
        Arrays.fill(dis, Integer.MAX_VALUE);

        graphs = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graphs.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graphs.get(v1).add(new Graph(v2, cost));
            graphs.get(v2).add(new Graph(v1, cost));
        }

        dijkstra();
        System.out.println(dis[N]);
    }

    private static void dijkstra() {
        PriorityQueue<Graph> pq = new PriorityQueue<>();
        pq.offer(new Graph(1, 0));
        dis[1] = 0;

        while (!pq.isEmpty()) {
            Graph graph = pq.poll();
            int nowV = graph.vertex;
            int nowC = graph.cost;
            
            if (nowC > dis[nowV]) continue;

            for (Graph tmp : graphs.get(nowV)) {
                if (dis[tmp.vertex] > nowC + tmp.cost) {
                    dis[tmp.vertex] = nowC + tmp.cost;
                    pq.offer(new Graph(tmp.vertex, nowC + tmp.cost));
                }
            }
        }
    }

    static class Graph implements Comparable<Graph> {
        private int vertex;
        private int cost;

        public Graph(int vertex, int cost) {
            this.vertex = vertex;
            this.cost = cost;
        }

        @Override
        public int compareTo(Graph o) {
            return cost - o.cost;
        }
    }
}
