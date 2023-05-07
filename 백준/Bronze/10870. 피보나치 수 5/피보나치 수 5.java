import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] dp;

    public static int fibo(int N) {
        if (N == 1) return 1;
        if (N < 0) return 0;
        if (dp[N] > 1) return dp[N];
        return dp[N] = fibo(N - 1) + fibo(N - 2);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        dp = new int[N + 2];

        dp[1] = 1;
        System.out.println(fibo(N));
    }
}
