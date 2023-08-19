import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long[][] dp;

    public static void solution(int M, int N) {
        for (int i = 2; i <= M; i++) {
            for (int j = 1; j <= N; j++) {
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            dp = new long[M + 1][N + 1];
            dp[1][0] = 1;

            for (int j = 0; j <= M; j++) {
                dp[j][0] = 1;
                dp[j][1] = 1;
            }
            
            solution(M, N);
            System.out.println(dp[M][N]);
        }
    }
}