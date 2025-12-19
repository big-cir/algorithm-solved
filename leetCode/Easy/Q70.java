// 시간복잡도: O(n), 공간복잡도: O(1)
class Solution {
    public int climbStairs(int n) {
        if (n < 2) return n;

        int prev1 = 2, prev2 = 1;
        for (int i = 3; i <= n; i++) {
            int current = prev2 + prev1;
            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }
}

// 시간복잡도: O(n), 공간복잡도: O(n)
class Solution {
    public int climbStairs(int n) {
        if (n < 2) return n;

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
        }

        return dp[n];
    }
}
