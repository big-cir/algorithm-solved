import java.util.*;
import java.io.*;

public class Main {

    public static int memoization(int N, int M, int[][] dp) {
        if (dp[N][M] > 0) return dp[N][M];
        if (N == M || M == 0) {
            return 1;
        } else {
            return dp[N][M] = memoization(N - 1, M - 1, dp) + memoization(N - 1, M, dp);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[][] dp = new int[M + 1][N + 1];
            System.out.println(memoization(M, N, dp));
        }
    }
}
