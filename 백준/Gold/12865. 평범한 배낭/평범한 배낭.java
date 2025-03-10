import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] wv = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            wv[i][0] = w;
            wv[i][1] = v;
        }

        int[][] dp = new int[N + 1][K + 1];
        for (int i = 1; i <= N; i++) {
            int[] info = wv[i - 1];
            int w = info[0];
            int v = info[1];

            for (int j = 1; j <= K; j++) {
                if (j >= w) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - w] + v);
                } else {
                    dp[i][j]= dp[i - 1][j];
                }
            }
        }

        int answer = 0;
        for (int i = 1; i <= N; i++) {
            answer = Math.max(answer, dp[i][K]);
        }

        System.out.println(answer);
    }
}
