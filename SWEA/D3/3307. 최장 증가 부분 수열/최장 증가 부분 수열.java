import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int[] arr, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            arr = new int[N];
            dp = new int[N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            dp[0] = 1;
            int answer = 0;
            for (int i = 1; i < arr.length; i++) {
                int max = 0;
                for (int j = i - 1; j >= 0; j--) {
                    if (arr[i] > arr[j]) {
                        if (dp[j] > max) {
                            max = dp[j];
                        }
                    }
                }
                dp[i] = max + 1;
                answer = Math.max(answer, dp[i]);
            }

            System.out.println("#" + tc + " " + answer);
        }
    }
}
