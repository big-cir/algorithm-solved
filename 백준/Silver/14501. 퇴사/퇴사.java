import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int N;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][2];
        for (int i = 0; i < N; i++) {
            arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int[] dp = new int[N + 2];
        for (int i = N; i >= 1; i--) {
            int day = arr[i - 1][0];
            int cost = arr[i - 1][1];

            if (i + day - 1 <= N) {
                dp[i] = Math.max(dp[i + 1], dp[i + day] + cost);
            } else {
                dp[i] = dp[i + 1];
            }
        }

        System.out.println(dp[1]);
    }
}