import java.util.*;
class Solution {
    
    class Info {
        private int idx;
        private int rank;
        
        public Info(int idx, int rank) {
            this.idx = idx;
            this.rank = rank;
        }
    }
    
    public int solution(int[] priorities, int location) {
        Queue<Info> queue = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            queue.offer(new Info(i, priorities[i]));
        }
        
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int x : priorities) pq.offer(x);

        int answer = 0;
        while (!pq.isEmpty()) {
            boolean flag = false;
            int priority = pq.poll();
            
            while (true) {
                Info now = queue.poll();
                
                if (now.rank == priority) {
                    answer++;
                    if (now.idx == location) flag = true;
                    break;
                } else {
                    queue.offer(now);
                }
            }
            
            if (flag) break;
        }
        
        return answer;
    }
}