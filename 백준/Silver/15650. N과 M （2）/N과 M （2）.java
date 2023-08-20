import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] ch, answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        ch = new int[N + 1];
        answer = new int[M];

        for (int i = 1; i <= N; i++) {
            ch[i] = 1;
            answer[0] = i;
            dfs(1, i);
        }
    }

    private static void dfs(int Level, int start) {
        if (Level == M) {
            for (int x : answer) {
                System.out.print(x + " ");
            }
            System.out.println();
            return;
        }

        for (int i = start; i <= N; i++) {
            if (ch[i] == 0) {
                ch[i] = 1;
                answer[Level] = i;
                dfs(Level + 1, i);
                ch[i] = 0;
            }
        }
    }
}
