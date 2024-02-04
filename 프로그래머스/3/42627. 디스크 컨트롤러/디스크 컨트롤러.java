import java.util.Arrays;
import java.util.Queue;
import java.util.PriorityQueue;

class Solution {
    static class Work implements Comparable<Work> {
        int start;
        int cost;
        
        public Work(int start, int cost) {
            this.start = start;
            this.cost = cost;
        }
        
        @Override
        public int compareTo(Work o) {
            return cost - o.cost;
        }
    }
    
    public int solution(int[][] jobs) {
        int answer = 0;
        Arrays.sort(jobs, (a1, b1) -> a1[0] - b1[0]);
        
        int jobIdx = 0;
        int currentTime = 0;
        int completedJob = 0;
        Queue<Work> pq = new PriorityQueue<>();
        
        while (completedJob < jobs.length) {
            // jobIdx는 jobs.length 보다 작아야하고,
            // 요청 시간은 현재 시간보다 작거나 같아야 함.
            while (jobIdx < jobs.length && jobs[jobIdx][0] <= currentTime) {
                pq.offer(new Work(jobs[jobIdx][0], jobs[jobIdx][1]));
                jobIdx++;
            }
            
            if (!pq.isEmpty()) {
                Work now = pq.poll();
                currentTime += now.cost;
                answer += (currentTime - now.start);
                completedJob++;
            } else {
                // currentTime += pq.peek().start;
                // A작업이 완료되고 현재 시간은 3일 때, B의 작업 시작시간이 5라면
                // 현재 우선순위 큐에는 작업 목록이 없다.
                // 두번쨰 while문 조건을 맞추면서 두 번째 작업을 큐에 추가하기 위해서 조건이 동일하도록 시간을 변경해야 함.
                currentTime = jobs[jobIdx][0];
            }
        }
        
        return answer / jobs.length;
    }
}