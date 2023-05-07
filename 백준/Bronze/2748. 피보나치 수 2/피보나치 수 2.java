import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static long[] dp;
    
    public static long topDown(int N) {
        if (N < 0) return 0;
        if (dp[N] > 0) return dp[N];
        return dp[N] = topDown(N - 2) + topDown(N - 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        dp = new long[N + 1];

        dp[0] = 0;
        dp[1] = 1;
        
        topDown(N);

        System.out.println(dp[N]);
    }
}
