import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        Queue<Integer> q1 = new LinkedList<>();
        for (int x : queue1) q1.offer(x);
        Queue<Integer> q2 = new LinkedList<>();
        for (int x :queue2) q2.offer(x);

        long sum1 = Arrays.stream(queue1).sum();
        long sum2 = Arrays.stream(queue2).sum();

        answer = 0;
        while (sum1 != sum2) {
            if (answer > (queue1.length + queue2.length) * 2) {
                answer = -1;
                break;
            }
            
            if (sum1 < sum2) {
                int val2 = q2.poll();
                q1.offer(val2);

                sum1 += val2;
                sum2 -= val2;
            } else if (sum1 > sum2) {
                int val1 = q1.poll();
                q2.offer(val1);

                sum1 -= val1;
                sum2 += val1;
            }
            answer++;
        }
        return answer;
    }
}