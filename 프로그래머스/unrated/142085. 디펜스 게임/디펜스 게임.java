import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Collections;
class Solution {
    // 병사 n
    // 적 enemy[] : 배열 라운드
    // 무적권 사용 시 라운드 클리어 가능 K 번
    // 4 2 4 5 3 3 1
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        int soldier = n;
        int pass = 0;
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int i = 0; i < enemy.length; i++) {
            int round = enemy[i];
            pq.offer(round);
            soldier -= round;

            if (soldier < 0) {
                if (pass < k) {
                    soldier += pq.poll();
                    pass++;
                } else {
                    break;
                }
            }
            answer++;
        }

        return answer;
    }
}