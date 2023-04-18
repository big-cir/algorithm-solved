import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    public static int solution(int n, int r, int[][] dp) {
        if (dp[n][r] > 0) return dp[n][r];
        if (n == r || r == 0) return 1;
        return dp[n][r] = solution(n - 1, r - 1, dp) + solution(n - 1, r, dp);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());


        for (int k = 0; k < T; k++) {
            int N = Integer.parseInt(br.readLine());
            int[][] dp = new int[N][N];
            System.out.println("#" + (k + 1));
            for (int i = 0; i < N; i++) {
                for (int j = 0; j <= i; j++) {
                    dp[i][j] = solution(i , j, dp);
                    System.out.print(dp[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}