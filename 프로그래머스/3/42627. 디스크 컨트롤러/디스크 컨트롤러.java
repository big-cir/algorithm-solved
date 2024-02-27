import java.util.*;

class Solution {
    
    static class Job implements Comparable<Job> {
        private int req;
        private int cost;
        
        public Job(int req, int cost) {
            this.req = req;
            this.cost = cost;
        }
        
        @Override
        public int compareTo(Job o) {
            return cost - o.cost;
        }
    }
    
    public int solution(int[][] jobs) {
        int n = jobs.length;
        Arrays.sort(jobs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        
        int answer = 0;
        int curJobIdx = 0;          // 현재 Job index
        int completedJobCnt = 0;    // 완료한 Job
        int currentTime = 0;        // 현재 시간
        
        Queue<Job> pq = new PriorityQueue<>();
        while (completedJobCnt < n) {
            // 언제까지 queue에 넣을것인가?
            // 1. jobIdx < n 
            // 2. 요청 시간이 현재 시간보다 작거나 같을 때
            while (curJobIdx < n && jobs[curJobIdx][0] <= currentTime) {
                pq.offer(new Job(jobs[curJobIdx][0], jobs[curJobIdx][1]));
                curJobIdx++;
            }
            
            if (!pq.isEmpty()) {
                Job job = pq.poll();
                currentTime += job.cost;
                answer += (currentTime - job.req);
                completedJobCnt++;
            } else {
                currentTime = jobs[curJobIdx][0];
            }
        }
        
        return answer / n;
    }
}