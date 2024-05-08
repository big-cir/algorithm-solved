import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        Queue<Integer> pq = new PriorityQueue<>();
        
        for (int x : scoville) pq.offer(x);
        
        // 모든 음식이 K 이상
        while (pq.peek() < K && pq.size() > 1) {
            int min = pq.poll();
            pq.offer(min + (pq.poll() * 2));
            answer++;
        }
        
        for (int x : pq) {
            if (x < K) return -1;
        }
        
        return answer;
    }
}