import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];

        int[][] schedule = new int[N + 1][2];
        for (int i = N; i > 0; i--) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            schedule[i][0] = Integer.parseInt(st.nextToken());
            schedule[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < dp.length; i++) {
            if (schedule[i][0] > i) {
                dp[i] = dp[i - 1];
            } else {
                dp[i] = Math.max(dp[i - 1], schedule[i][1] + dp[i - schedule[i][0]]);
            }
        }

        System.out.println(dp[N]);
    }
}
