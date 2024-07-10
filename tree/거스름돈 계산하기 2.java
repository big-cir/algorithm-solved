https://www.codetree.ai/problems/calculating-change2/description

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        int[][] coins = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            coins[i][0] = Integer.parseInt(st.nextToken());
            coins[i][1] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[N + 1][target + 1];
        for (int i = 0; i <= N; i++) {
            Arrays.fill(dp[i], 20001);
            dp[i][0] = 0;
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= target; j++) {
                dp[i][j] = dp[i - 1][j];

                for (int k = 1; k <= coins[i - 1][1]; k++) {
                    if (k * coins[i - 1][0] > j) continue;

                    if (dp[i - 1][j - k * coins[i - 1][0]] != 20001) {
                        dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - k * coins[i - 1][0]] + k);
                    }
                }
            }
        }

        int answer = dp[N][target];
        if (dp[N][target] == 20001) answer = -1;

        System.out.println(answer);
    }
}
