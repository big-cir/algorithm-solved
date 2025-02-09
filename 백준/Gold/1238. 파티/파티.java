import java.io.*;
import java.util.*;

public class Main {

    static class Info implements Comparable<Info> {
        int v;
        int cost;

        public Info(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }

        @Override
        public int compareTo(Info i) {
            return this.cost - i.cost;
        }
    }

    static int N, M, X;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        List<List<Info>> graph = new ArrayList<>();
        List<List<Info>> reverse = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
            reverse.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph.get(v1).add(new Info(v2, cost));
            reverse.get(v2).add(new Info(v1, cost));
        }

        int answer = Integer.MIN_VALUE;
        int[] dis = new int[N + 1];
        int[] dis2 = new int[N + 1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        Arrays.fill(dis2, Integer.MAX_VALUE);
        dis[X]= 0;
        dis2[X] = 0;

        search(X, dis, graph);
        search(X, dis2, reverse);

        for (int i = 1; i <= N; i++) {
            answer = Math.max(answer, dis[i] + dis2[i]);
        }

        System.out.println(answer);
    }

    private static void search(int v, int[] dis, List<List<Info>> graph) {
        Queue<Info> pq = new PriorityQueue<>();
        pq.offer(new Info(v, 0));

        while (!pq.isEmpty()) {
            Info now = pq.poll();

            for (Info next : graph.get(now.v)) {
                if (dis[next.v] > now.cost + next.cost) {
                    dis[next.v] = now.cost + next.cost;
                    pq.offer(new Info(next.v, now.cost + next.cost));
                }
            }
        }
    }
}
