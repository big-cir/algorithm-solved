import java.util.*;

class Solution {
    public int solution(int n, int[] money) {
        int div = 1000000007;
        int[][] dp = new int[money.length + 1][n + 1];
        
        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = 1;
            for (int j = 1; j <= n; j++) {
                if (j >= money[i - 1]) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - money[i - 1]];
                    dp[i][j] %= div;
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        
        return dp[money.length][n];
    }
}