import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int[] ch;

    public static void dfs(int Level, int N, int M, String str, int startIdx) {
        if (Level == M) {
            for (char x : str.toCharArray()) {
                System.out.print(x + " ");
            }
            System.out.println();
        } else {
            for (int i = startIdx; i < N; i++) {
                if (ch[i] == 0) {
                    ch[i] = 1;
                    dfs(Level + 1, N, M, str + (i + 1), i);
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

        dfs(0, N, M, "", 0);
    }
}
