import java.util.*;
import java.util.stream.Collectors;

class Solution {
    static List<List<Node>> graph;

    static class Node implements Comparable<Node> {
        int vertex;
        int cost;

        Node(int v, int c) {
            this.vertex = v;
            this.cost = c;
        }

        @Override
        public int compareTo(Node o) {
            return cost - o.cost;
        }
    }
    
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        Arrays.sort(summits);
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) graph.add(new ArrayList());
        for (int i = 0; i < paths.length; i++) {
            graph.get(paths[i][0]).add(new Node(paths[i][1], paths[i][2]));
            graph.get(paths[i][1]).add(new Node(paths[i][0], paths[i][2]));
        }
        int[] answer = {0, Integer.MAX_VALUE};
        dijkstra(n, gates, summits, answer);
        return answer;
    }
    
    public static void dijkstra(int n, int[] gates, int[] summits, int[] answer) {
        int[] dis = new int[n + 1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        Set<Integer> set = Arrays.stream(summits).boxed().collect(Collectors.toSet());

        Queue<Node> pq = new PriorityQueue<>();
        for (int gate : gates) {
            pq.offer(new Node(gate, 0));
            dis[gate] = 0;
        }

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            
            if (dis[now.vertex] < now.cost ||set.contains(now.vertex)) continue;

            for (Node next : graph.get(now.vertex)) {
                int nextIntensity = Math.max(now.cost, next.cost);
                if (nextIntensity < dis[next.vertex]) {
                    dis[next.vertex] = nextIntensity;
                    pq.offer(new Node(next.vertex, nextIntensity));
                }
            }
        }

        for (int summit : summits) {
            if (answer[1] > dis[summit]) {
                answer[0] = summit;
                answer[1] = dis[summit];
            }
        }
    }
}