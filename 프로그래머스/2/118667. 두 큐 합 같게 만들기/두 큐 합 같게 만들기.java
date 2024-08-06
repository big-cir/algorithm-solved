import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int N = queue1.length;
        int M = queue2.length;
        Queue<Integer> ll1 = new LinkedList<>();
        Queue<Integer> ll2 = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            ll1.offer(queue1[i]);
            ll2.offer(queue2[i]);
        }

        int answer = 0;
        long sum1 = ll1.stream().mapToInt(Integer::intValue).sum();
        long sum2 = ll2.stream().mapToInt(Integer::intValue).sum();
        while (answer < 2 * (N + M)) {
            if (sum1 == sum2) break;
            else if (sum1 > sum2) {
                int value = ll1.poll();
                sum1 -= value;
                sum2 += value;
                ll2.offer(value);
            } else {
                int value = ll2.poll();
                sum1 += value;
                sum2 -= value;
                ll1.offer(value);
            }
            answer++;
        }

        if (answer == 2 * (N + M)) answer = -1;
        return answer;
    }
}