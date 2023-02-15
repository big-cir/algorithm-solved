import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<ArrayList<Graph>> graph;
    static int[] dis;

    static class Graph implements Comparable<Graph> {
        private int vertex;
        private int cost;

        public Graph(int vertex, int cost) {
            this.vertex = vertex;
            this.cost = cost;
        }

        @Override
        public int compareTo(Graph o) {
            return this.cost - o.cost;
        }
    }

    public static void solution(int vertex, int arrive_vertex) {
        PriorityQueue<Graph> pq = new PriorityQueue<>();
        pq.offer(new Graph(vertex, 0));
        dis[vertex] = 0;

        while (!pq.isEmpty()) {
            Graph tmp = pq.poll();
            int now = tmp.vertex;
            int now_Cost = tmp.cost;

            if (now_Cost > dis[now]) continue;

            for (Graph g : graph.get(now)) {
                if (dis[g.vertex] > g.cost + now_Cost) {
                    dis[g.vertex] = g.cost + now_Cost;
                    pq.offer(new Graph(g.vertex, g.cost + now_Cost));
                }
            }
        }
        System.out.println(dis[arrive_vertex]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());    // 도시의 개수
        int M = Integer.parseInt(br.readLine());    // 버스의 개수

        dis = new int[N + 1];
        Arrays.fill(dis, Integer.MAX_VALUE);

        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s_v = Integer.parseInt(st.nextToken());
            int a_v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph.get(s_v).add(new Graph(a_v, w));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start_v = Integer.parseInt(st.nextToken());
        int end_v = Integer.parseInt(st.nextToken());
        solution(start_v, end_v);
    }
}
