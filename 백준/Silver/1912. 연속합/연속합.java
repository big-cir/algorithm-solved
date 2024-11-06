import java.util.*;
import java.io.*;

public class Main {

    static int N, K;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N + 1];
        dp[1] = arr[1];

        int answer = arr[1];
        for (int i = 2; i <= N; i++) {
            dp[i] = Math.max(dp[i - 1] + arr[i], arr[i]);
            answer = Math.max(answer, dp[i]);
        }

        System.out.println(answer);
    }
}