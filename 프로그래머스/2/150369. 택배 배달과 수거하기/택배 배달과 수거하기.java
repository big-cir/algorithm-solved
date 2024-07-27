import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class Solution {
    
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        Deque<Integer> deliver = new ArrayDeque<>();
        Deque<Integer> pick = new ArrayDeque<>();

        Arrays.stream(deliveries).forEach(deliver::push);
        Arrays.stream(pickups).forEach(pick::push);

        long answer = 0;
        while (true) {
            if (deliver.isEmpty() && pick.isEmpty()) break;

            // 배달 & 수거 0 = 계산 x
            if (!deliver.isEmpty()) {
                if (deliver.peek() == 0) {
                    deliver.pop();
                    continue;
                }
            }

            if (!pick.isEmpty()) {
                if (pick.peek() == 0) {
                    pick.pop();
                    continue;
                }
            }

            answer += Math.max(deliver.size(), pick.size()) * 2L;

            int limit = 0;
            while (true) {
                if (!deliver.isEmpty()) {
                    int capacity = deliver.pop();
                    int sum = capacity + limit;

                    if (sum > cap) {
                        deliver.push(sum - cap);
                        break;
                    }

                    limit += capacity;
                } else break;
            }

            limit = 0;
            while (true) {
                if (!pick.isEmpty()) {
                    int capacity = pick.pop();
                    int sum = capacity + limit;

                    if (sum > cap) {
                        pick.push(sum - cap);
                        break;
                    } else {
                        limit += capacity;
                    }
                } else break;
            }
        }

        return answer;
    }
}