import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][N];
        for (int i = 0; i < N; i++) arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[][] dp = new int[N][N];

        dp[0][0] = arr[0][0];

        for (int i = 1 ; i < N; i++) {
            dp[i][0] = dp[i - 1][0] + arr[i][0]; 
        }
        for (int i = 1; i < N; i++) {
            for (int j = 1; j < i + 1; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1]) + arr[i][j];
            }
        }
        
        int answer = 0;
        for (int i = 0; i < N; i++) {
            answer = Math.max(answer, dp[N - 1][i]);
        }
        System.out.println(answer);
    }
}