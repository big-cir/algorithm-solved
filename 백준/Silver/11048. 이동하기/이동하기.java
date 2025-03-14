import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            arr[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int[][] dp = new int[N][M];
        dp[0][0] = arr[0][0];
        for (int i = 1; i < M; i++) {
            dp[0][i] = dp[0][i - 1] + arr[0][i];
        }

        int[] dx = {-1, -1, 0};
        int[] dy = {0, -1, -1};
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int k = 0; k < 3; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];

                    if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                        dp[i][j] = Math.max(dp[i][j], dp[nx][ny] + arr[i][j]);
                    }
                }
            }
        }

        System.out.println(dp[N - 1][M - 1]);
    }
}
