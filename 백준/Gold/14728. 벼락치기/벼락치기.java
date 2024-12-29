import java.io.*;
import java.util.*;

public class Main {
    static int N, T;
    static int[][] arr, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        arr = new int[N + 1][2];
        dp = new int[N + 1][T + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            int score = Integer.parseInt(st.nextToken());
            arr[i][0] = time;
            arr[i][1] = score;
        }

        for (int i = 1; i <= T; i++) {
            if (i >= arr[1][0]) {
                dp[1][i] = arr[1][1];
            }
        }

        for (int i = 2; i <= N; i++) {
            int time = arr[i][0];
            int score = arr[i][1];

            for (int j = 1; j <= T; j++) {
                if (j >= time) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - time] + score);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        System.out.println(dp[N][T]);
    }
}