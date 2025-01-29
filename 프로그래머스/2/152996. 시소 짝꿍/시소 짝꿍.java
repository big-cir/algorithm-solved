import java.util.*;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        Arrays.sort(weights);
        
        int cnt = 0;
        for (int i = 0; i < weights.length - 1; i++) {
            // 같은 weight가 연속되는 경우 최적화
            if (i > 0 && weights[i] == weights[i - 1]) {
                cnt--;
                answer += cnt;
                continue;
            }
            
            cnt = 0;
            // 현재 weight와 짝이 될 수 있는 다음 weight들 확인
            for (int j = i + 1; j < weights.length; j++) {
                int w1 = weights[i];
                int w2 = weights[j];
                
                // 가능한 모든 비율 확인
                if (w1 == w2 || 
                    w1 * 4 == w2 * 3 || 
                    w1 * 3 == w2 * 2 || 
                    w1 * 2 == w2) {
                    cnt++;
                }
            }
            answer += cnt;
        }
        
        return answer;
    }
}