import java.util.*;
import java.io.*;

public class Main {

    static int N, K;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        int[] sums = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sums[i] = sums[i - 1] + arr[i];
        }

        int[] dp = new int[N + 1];
        dp[N] = sums[N];
        for (int i = N - 1; i > 0; i--) {
            dp[i] = Math.max(dp[i + 1], sums[i]);
        }

        int answer = Integer.MIN_VALUE;
        for (int i = K; i <= N; i++) {
            answer = Math.max(answer, dp[i] - sums[i - K]);
        }
        
        System.out.println(answer);
    }
}
