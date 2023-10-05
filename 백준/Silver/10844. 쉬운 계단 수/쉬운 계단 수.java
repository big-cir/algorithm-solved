import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int div = 1000000000;
    static long[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        dp = new long[N + 1][10];

        for (int i = 1; i < 10; i++) {
            dp[1][i] = 1;
        }

        if (N >= 2) {
            for (int i = 2; i <= N; i++ ) {
                for (int j = 0; j < 10; j++) {
                    if (j == 0) {
                        dp[i][j] = dp[i - 1][1] % div;
                        continue;
                    }
                    if (j == 9) {
                        dp[i][j] = dp[i - 1][8] % div;
                        continue;
                    }
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % div;
                }
            }
        }

        long answer = 0;
        for (int i = 0; i < 10; i++) {
            answer += dp[N][i];
        }
        System.out.println(answer % div);
    }
}
