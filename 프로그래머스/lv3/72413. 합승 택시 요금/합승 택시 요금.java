import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
class Solution {
    static int[] disD, disA, disB;
    static List<List<Edge>> graph = new ArrayList<>();

    static class Edge implements Comparable<Edge> {
        private int v;
        private int cost;

        public Edge(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return cost - o.cost;
        }
    }

    public static void init(int n, int[][] fares) {
        disD = new int[n + 1];
        disA = new int[n + 1];
        disB = new int[n + 1];
        Arrays.fill(disD, Integer.MAX_VALUE);
        Arrays.fill(disA, Integer.MAX_VALUE);
        Arrays.fill(disB, Integer.MAX_VALUE);
        disD[0] = 0;
        disA[0] = 0;
        disB[0] = 0;

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < fares.length; i++) {
            int[] input = fares[i];
            graph.get(input[0]).add(new Edge(input[1], input[2]));
            graph.get(input[1]).add(new Edge(input[0], input[2]));
        }
    }

    public static void dijkstra(int start, int[] dis) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(start, 0));
        dis[start] = 0;

        while (!pq.isEmpty()) {
            Edge tmp = pq.poll();
            int nowV = tmp.v;
            int nowCost = tmp.cost;

            if (nowCost > dis[nowV]) continue;
            for (Edge ob : graph.get(nowV)) {
                if (dis[ob.v] > nowCost + ob.cost) {
                    dis[ob.v] = nowCost + ob.cost;
                    pq.offer(new Edge(ob.v, nowCost + ob.cost));
                }
            }
        }
    }

    public int solution(int n, int start, int aHouse, int bHouse, int[][] fares) {
        init(n, fares);
        dijkstra(start, disD);
        dijkstra(aHouse, disA);
        dijkstra(bHouse, disB);

        System.out.println(Arrays.toString(disD));
        System.out.println(Arrays.toString(disA));
        System.out.println(Arrays.toString(disB));

        int answer = Integer.MAX_VALUE;
        // f[i][j] 4 -> 1 -> 35 < 50 == 35
        // 임의의 점.
        for (int i = 1; i <= n; i++) {
            answer = Math.min(answer, disD[i] + disA[i] + disB[i]);
        }
        return answer;
    }
}