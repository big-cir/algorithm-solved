import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for (int i = 1; i <= tc; i++) {
            int n = Integer.parseInt(br.readLine());
            long[][] dp = new long[n + 1][10];

            // 초기화
            for (int j = 0; j <= 9; j++) {
                dp[1][j] = 1;
            }

            for (int j = 2; j <= n; j++) {
                for (int k = 0; k <= 9; k++) {
                    long tmp = 0;
                    for (int l = k; l <= 9; l++) {
                        tmp += dp[j - 1][l];
                    }
                    dp[j][k] = tmp;
                }
            }

            long answer = 0;
            for (int j = 0; j <= 9; j++) {
                answer += dp[n][j];
            }
            System.out.println(answer);
        }
    }
}
