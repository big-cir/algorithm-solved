import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] dp = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // 6 10 13 9 8 1
        if (N == 1) {
            System.out.println(arr[0]);
            return;
        }

        if (N == 2) {
            //dp[2] = Math.max(dp[1], Math.max(dp[0] + arr[2], arr[1] + arr[2]));
            System.out.println(arr[0] + arr[1]);
            return;
        }
        
        dp[0] = arr[0];
        dp[1] = dp[0] + arr[1];
        dp[2] = Math.max(dp[1], Math.max(dp[0] + arr[2], arr[1] + arr[2]));

        // dp[0] = 6, dp[1] = 16, dp[2] = 23
        // dp[3] = 28, Math.max(23, (16 + 9, 6 + 13 + 9))
        for (int i = 3; i < N; i++) {
            // dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + arr[i], dp[i - 3] + dp[i - 1] + arr[i]));
            dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + arr[i], dp[i - 3] + arr[i - 1] + arr[i]));
        }

        System.out.println(dp[N - 1]);
    }
}
