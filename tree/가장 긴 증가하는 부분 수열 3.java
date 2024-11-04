import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] dp = new int[N];
        dp[0] = 1;
        for (int i = 1; i < N; i++) {
            int fix = arr[i];
            for (int j = i - 1; j >= 0; j--) {
                if (fix > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j]);
                }
            }

            dp[i]++;
        }

        System.out.println(Arrays.stream(dp).max().getAsInt());
    }
}
