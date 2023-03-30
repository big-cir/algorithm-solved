import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[][] dp = new int[15][15];
        for (int i = 0; i < dp.length; i++) {
            dp[i][1] = 1;
            dp[0][i] = i;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 2; j < dp.length; j++) {
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
            }
        }

        for (int i = 0; i < T; i++) {
            int K = Integer.parseInt(br.readLine());
            int N = Integer.parseInt(br.readLine());
            System.out.println(dp[K][N]);
        }
    }
}
