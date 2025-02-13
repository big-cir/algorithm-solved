import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[][] dp = new int[N + 1][M + 1];
        for (int i = 0; i <= N; i++) Arrays.fill(dp[i], -1);
        dp[0][S] = S;

        for (int i = 1; i <= N; i++) {
            int volume = arr[i - 1];
            for (int j = 0; j <= M; j++) {
                if (dp[i - 1][j] == -1) continue;

                if (j + volume <= M) dp[i][j + volume] = Math.max(dp[i][j + volume], j + volume);
                if (j - volume >= 0) dp[i][j - volume] = Math.max(dp[i][j - volume], j - volume);
            }
        }

        int answer = -1;
        for (int j = 0; j <= M; j++) {
            answer = Math.max(answer, dp[N][j]);
        }
        
        System.out.println(answer);
    }
}
