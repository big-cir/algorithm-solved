import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        Queue<Integer> q1 = new LinkedList<>();
        for (int x : queue1) q1.offer(x);
        
        Queue<Integer> q2 = new LinkedList<>();
        for (int x : queue2) q2.offer(x);
        
        int answer = 0;
        int size = (queue1.length + queue2.length) * 2;
        
        long sum1 = Arrays.stream(queue1).sum();
        long sum2 = Arrays.stream(queue2).sum();
        while (answer <= size) {
            if (sum1 == sum2) break;
            
            if (sum1 < sum2) {
                int val = q2.poll();
                sum1 += val;
                sum2 -= val;
                q1.offer(val);
            } else {
                int val = q1.poll();
                sum1 -= val;
                sum2 += val;
                q2.offer(val);
            }
            answer++;
        }
        
        return answer == size + 1 ? -1 : answer;
    }
}