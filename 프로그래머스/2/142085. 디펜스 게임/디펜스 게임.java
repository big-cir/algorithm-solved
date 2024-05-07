
import java.util.*;
// 라운드마다 enemy[i] 등장
// 남은 병사 < 현재 라운드 적 : break
// k번의 무적권
// O(N) -> dp(X)

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        Queue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        
        int cnt = 0;
        for (int em : enemy) {
            pq.offer(em);
            n -= em;
            
            if (n < 0) {
                if (cnt < k) {
                    n += pq.poll();
                    cnt++;
                } else break;
            }
            answer++;
        }
        
        return answer;
    }
}