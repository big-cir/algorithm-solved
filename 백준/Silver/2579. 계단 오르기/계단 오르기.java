import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] A;
    static Integer[] dp;

    public static int recur_sol(int N) {
        if (dp[N] != null) {
            return dp[N];
        } else {
            return dp[N] = Math.max(recur_sol(N - 2), recur_sol(N - 3) + A[N - 1]) + A[N];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        A = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }

        dp = new Integer[N + 1];
        dp[0] = 0;
        dp[1] = A[1];

        if (N >= 2) {
            dp[2] = Math.max(A[2], A[1] + A[2]);
        }

        recur_sol(N);
        System.out.println(dp[N]);
    }
}
