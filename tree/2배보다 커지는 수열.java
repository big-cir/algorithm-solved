import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int MOD = 1000000007;
        long[][] dp = new long[N + 1][M + 1];
        for (int j = 1; j <= M; j++) dp[1][j] = 1;

        for (int i = 2; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                for (int k = 1; k <= j / 2; k++) {
                    dp[i][j] += dp[i - 1][k];
                    dp[i][j] %= MOD;
                }
            }
        }

        long answer = 0;
        for (int i = 1; i <= M; i++) {
            answer += dp[N][i];
            answer %= MOD;
        }

        System.out.println(answer);
    }
}
