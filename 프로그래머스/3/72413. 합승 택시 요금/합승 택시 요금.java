import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.PriorityQueue;
import java.util.Arrays;

class Solution {
    
    static int answer;
    static List<List<Node>> graph;
    
    static class Node implements Comparable<Node> {
        int vertex;
        int cost;
        
        public Node(int v, int c) {
            this.vertex = v;
            this.cost = c;
        }
        
        @Override
        public int compareTo(Node o) {
            return cost - o.cost;
        }
    }
    
    // [4, 1, 10], [3, 5, 24], [5, 6, 2], [3, 1, 41], [5, 1, 24], [4, 6, 50], [2, 4, 66], [2, 3, 22], [1, 6, 25]
    // s 출발 지점, a 도착, b 도착
    // 4같이 출발, a 6도착, b 2 도착
    public int solution(int n, int s, int a, int b, int[][] fares) {
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());
        for (int i = 0; i < fares.length; i++) {
            graph.get(fares[i][0]).add(new Node(fares[i][1], fares[i][2]));
            graph.get(fares[i][1]).add(new Node(fares[i][0], fares[i][2]));
        }
        
        answer = Integer.MAX_VALUE;
        int[] disA = new int[n + 1];
        int[] disB = new int[n + 1];
        int[] disAll = new int[n + 1];
        
        // A에서 모든경로 최솟값, B에서 모든경로 최솟값, start에서 모든 경로 최솟값
        // [2147483647, 25, 48, 26, 35, 2, 0]
        // [2147483647, 63, 0, 22, 66, 46, 48]
        // [2147483647, 10, 66, 51, 0, 34, 35]
        distkra(disA, n, a);
        distkra(disB, n, b);
        distkra(disAll, n, s);
        
        for (int i = 1; i <= n; i++) answer = Math.min(answer, disA[i] + disB[i] + disAll[i]);
        return answer;
    }
    
    public void distkra(int[] dis, int n, int start) {
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[start] = 0;
        
        Queue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        
        while (!pq.isEmpty()) {
            Node now = pq.poll();
            if (dis[now.vertex] < now.cost) continue;
            
            for (Node next : graph.get(now.vertex)) {
                if (dis[next.vertex] > now.cost + next.cost) {
                    dis[next.vertex] = now.cost + next.cost;
                    pq.offer(new Node(next.vertex, now.cost + next.cost));
                }
            }
        }
    }
}