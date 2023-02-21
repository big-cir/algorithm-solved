import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int V, answer = Integer.MIN_VALUE;
    static int[] dis, ch;
    static ArrayList<ArrayList<Point>> graph;

    static class Point {
        private int end_v, cost;

        public Point(int end_v, int cost) {
            this.end_v = end_v;
            this.cost = cost;
        }
    }


    static void BFS(int start_vertex) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start_vertex);
        ch[start_vertex] = 1;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (Point p : graph.get(cur)) {
                int endV = p.end_v;
                int cost = p.cost;

                if (ch[endV] == 0) {
                    ch[endV] = 1;
                    queue.add(endV);
                    dis[endV] = dis[cur] + cost;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        V = Integer.parseInt(br.readLine());

        ch = new int[V + 1];
        dis = new int[V + 1];
        graph = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }

        StringTokenizer st = null;
        for (int i = 0; i < V; i++) {
            st = new StringTokenizer(br.readLine());
            int start_vertex = Integer.parseInt(st.nextToken());

            while (true) {
                int end_vertex = Integer.parseInt(st.nextToken());
                if (end_vertex == -1) {
                    break;
                }
                int dis = Integer.parseInt(st.nextToken());
                graph.get(start_vertex).add(new Point(end_vertex, dis));
            }
        }

        BFS(1);

        int max = 1;
        for (int i = 1; i <= V; i++) {
            if (dis[max] < dis[i]) {
                max = i;
            }
        }

        Arrays.fill(dis, 0);
        Arrays.fill(ch, 0);

        ch[max] = 1;
        BFS(max);

        Arrays.sort(dis);
        System.out.println(dis[V]);
    }
}