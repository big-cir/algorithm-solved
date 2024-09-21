import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int T, W;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        int[][] dp = new int[T + 1][W + 1];
        int value = Integer.parseInt(br.readLine());
        if (value == 1) {
            dp[1][0] = 1;
        } else {
            dp[1][1] = 1;
        }

        for (int i = 2; i <= T; i++) {
            value = Integer.parseInt(br.readLine());

            for (int j = 0; j <= W; j++) {
                if (j == 0) {
                    if (value == 1) {
                        dp[i][j] = dp[i - 1][j] + 1;
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
                // 2번으로 움직였는데,
                else if (j % 2 == 1) {
                    // 자두가 떨어진 위치가 1인 경우
                    if (value == 1) {
                        // 이전에 1번 위치와 2번 위치의 값을 비교
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1]);
                    }
                    // 자두가 떨어진 위치가 2인 경우
                    else {
                        // 이전에 1번 위치와 2번 위치의 값을 비교하고 + 1
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1]) + 1;
                    }
                } else {
                    if (value == 1) {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1]) + 1;
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1]);
                    }
                }
            }
        }

        int answer = 0;
        for (int i = 0; i <= W; i++) {
            answer = Math.max(dp[T][i], answer);
        }

        System.out.println(answer);
    }
}