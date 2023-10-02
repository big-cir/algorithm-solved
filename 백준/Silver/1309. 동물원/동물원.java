import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        dp = new int[N + 1][3];

        // 없을떄, 좌측, 우측 : 2 * 1 = 3
        dp[1][0] = 1;
        dp[1][1] = 1;
        dp[1][2] = 1;

        // 2 * 2
        // 0 0 |
        // 0 0 |
        for (int i = 2; i < N + 1; i++) {
            dp[i][0] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]) % 9901;
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % 9901;
            dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % 9901;
        }

        int answer= 0;
        for (int i = 0; i < 3; i++) {
            answer += dp[N][i];
        }
        System.out.println(answer % 9901);
    }
}