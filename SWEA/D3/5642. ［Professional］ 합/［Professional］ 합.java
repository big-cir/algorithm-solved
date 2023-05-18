import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int max;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int[] dp = new int[N];
            dp[0] = arr[0];
            max = Integer.MIN_VALUE;
            for (int i = 1; i < N; i++) {
                dp[i] = Math.max(arr[i], dp[i - 1] + arr[i]);
            }
            
            for (int i = 0; i < N; i++) {
                max = Math.max(dp[i], max);
            }
            
            System.out.println("#" + tc + " " + max);
        }
    }
}
