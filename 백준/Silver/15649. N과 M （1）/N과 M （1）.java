import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int[] ch, answer;

    public static void dfs(int Level, int N, int M) {
        if (Level == M) {
            for (int i = 1; i <= M; i++) {
                System.out.print(answer[i] + " ");
            }
            System.out.println();
            return;
        } else {
            for (int i = 1; i <= N; i++) {
                if (ch[i] == 0) {
                    ch[i] = 1;
                    answer[Level + 1] = i;
                    dfs(Level + 1, N , M);
                    ch[i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        ch = new int[N + 1];
        answer = new int[M + 1];

        dfs(0, N, M);
    }
}
