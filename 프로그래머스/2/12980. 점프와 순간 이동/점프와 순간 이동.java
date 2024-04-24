import java.util.*;

// 순간이동 : *2, 건전지 소모 X
// 0 -> 5, K = 5
// 0 -> 2 * 2 + 1, K = 3;
// 0 -> 1 * 2, * 2, + 1
public class Solution {
    public int solution(int n) {
        int answer = 1;
        if (n == 1) return answer;

        while (n != 1) {
            if (n % 2 == 1) {
                n--;
            } else {
                n /= 2;
                continue;
            }
            answer++;
        }
        
        return answer;

//         int[] dp = new int[n + 1];
//         dp[1] = 1;

//         for (int i = 2; i <= tmp; i++) {
//             dp[i] = i % 2 == 1 ? Math.min(dp[i / 2] + 1, i) : Math.min(dp[i / 2], i);
//         }
        
//         return dp[n];
    }
}