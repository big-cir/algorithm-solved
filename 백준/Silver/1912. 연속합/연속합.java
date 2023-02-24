import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, answer = Integer.MIN_VALUE;
    static int [] A, dp;

    public static int DFS(int N) {
        if (N < 0) {
            return 0;
        }
        dp[N] = Math.max(A[N], A[N] + DFS(N - 1));
        answer = Math.max(answer, dp[N]);

        return dp[N];
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        dp = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        dp[0] = A[0];
        DFS(N - 1);
        System.out.println(answer);
    }
}
