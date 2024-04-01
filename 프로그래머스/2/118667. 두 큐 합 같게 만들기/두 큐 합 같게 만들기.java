import java.util.Arrays;
import java.util.Queue;
import java.util.LinkedList;

class Solution {
    // 길이 <= 300,000;
    public int solution(int[] queue1, int[] queue2) {
        int answer = Integer.MAX_VALUE;
        Queue<Integer> q1 = new LinkedList<>();
        for (int x : queue1) q1.offer(x);
        Queue<Integer> q2 = new LinkedList<>();
        for (int x : queue2) q2.offer(x);
        
        long sum1 = Arrays.stream(queue1).sum();
        long sum2 = Arrays.stream(queue2).sum();
        int maxChance = (queue1.length + queue2.length) * 2;
        
        int cnt = 0;
        while (sum1 != sum2 && cnt < maxChance) {
            if (sum1 == sum2) break;
            else if (sum1 < sum2) {
                int tmp = q2.poll();
                q1.offer(tmp);
                sum1 += tmp;
                sum2 -= tmp;
            } else {
                int tmp = q1.poll();
                q2.offer(tmp);
                sum2 += tmp;
                sum1 -= tmp;
            }
            cnt++;
        }
        answer = Math.min(answer, cnt);
        
        if (answer == maxChance) return -1;
        return answer;
    }
}