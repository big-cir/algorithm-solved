// 완탐 : O(N) = 백억 (x);
import java.util.Arrays;
class Solution {
    static int[] sits = new int[] {2, 3, 4};
    
    public long solution(int[] weights) {
        long answer = 0;

        Arrays.sort(weights);
        int cnt = 0;
        for (int i = 0; i < weights.length - 1; i++) {
            if (i > 0 && weights[i] == weights[i - 1]) {
                cnt--;
                answer += cnt;
                continue;
            }

            cnt = 0;
            for (int j = i + 1; j < weights.length; j++) {
                if (weights[i] == weights[j]) cnt++;
                else if (weights[i] * 4 == weights[j] * 3) cnt++;
                else if (weights[i] * 3 == weights[j] * 2) cnt++;
                else if (weights[i] * 2 == weights[j]) cnt++;
            }
            answer += cnt;
        }
        return answer;
    }
}