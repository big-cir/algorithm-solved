import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N, K;       // 물품의 수, 버틸 무게

    public static class Pack {
        private int w;  // 물건의 무게
        private int v;  // 물건의 가치

        public Pack(int w, int v) {
            this.w = w;
            this.v = v;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        ArrayList<Pack> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            list.add(new Pack(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        int[][] dp = new int[N + 1][K + 1];
        for (int i = 1; i <= list.size(); i++) {
            Pack pack = list.get(i - 1);
            for (int j = 1; j <= K; j++) {
                if (j >= pack.w) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - pack.w] + pack.v);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        System.out.println(dp[N][K]);
    }
}
