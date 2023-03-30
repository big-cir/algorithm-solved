import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] dp;
    static int divNum = 10007;

    public static int combi(int N, int K) {
        if (dp[N][K] > 0) return dp[N][K];
        if (N == K || K == 0) {
            return 1;
        } else {
            return dp[N][K] = (combi(N - 1, K - 1) + combi(N - 1, K)) % divNum;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        dp = new int[N + 1][K + 1];

        int answer = combi(N, K) ;
        System.out.println(answer);
    }
}