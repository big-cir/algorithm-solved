import java.util.*;

class Solution {
    static List<List<Town>> graph;
    
    static class Town implements Comparable<Town> {
        private int v;
        private int cost;
        
        public Town(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }
        
        @Override
        public int compareTo(Town t) {
            return cost - t.cost;
        }
    }
        
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());
        for (int i = 0; i < road.length; i++) {
            int[] info = road[i];
            graph.get(info[0]).add(new Town(info[1], info[2]));
            graph.get(info[1]).add(new Town(info[0], info[2]));
        }

        Queue<Town> pq = new PriorityQueue<>();
        pq.offer(new Town(1, 0));
        
        int[] dis = new int[N + 1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[1] = 0;
        
        while (!pq.isEmpty()) {
            Town now = pq.poll();
            
            for (Town next : graph.get(now.v)) {
                if (dis[next.v] > now.cost + next.cost) {
                    dis[next.v] = now.cost + next.cost;
                    pq.offer(new Town(next.v, now.cost + next.cost));
                }
            }
        }
        
        System.out.println(Arrays.toString(dis));
        for (int i = 1; i <= N; i++) {
            if (dis[i] <= K) answer++;
        }
        

        return answer;
    }
}