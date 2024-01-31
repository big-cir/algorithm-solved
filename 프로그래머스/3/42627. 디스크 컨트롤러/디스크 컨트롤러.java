import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    static class Node implements Comparable<Node> {
        int request;
        int cost;
        
        Node(int request, int cost) {
            this.request = request;
            this.cost = cost;
        }
        
        @Override
        public int compareTo(Node node) {
            return cost - node.cost;
        }
    }
    
    public int solution(int[][] jobs) {
        int answer = 0;
        
        Arrays.sort(jobs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int completedJobs = 0;
        int jobIdx = 0;
        int currentTime = 0;

        while (completedJobs < jobs.length) {
            while (jobIdx < jobs.length && jobs[jobIdx][0] <= currentTime) {
                pq.offer(new Node(jobs[jobIdx][0], jobs[jobIdx][1]));
                jobIdx++;
            }

            if (!pq.isEmpty()) {
                Node now = pq.poll();
                currentTime += now.cost;
                answer += (currentTime - now.request);
                completedJobs++;
            } else {
                currentTime = jobs[jobIdx][0];
            }
        }
        
        return answer / completedJobs;
    }
}