import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int N, M;
    public static StringBuilder sb = new StringBuilder();

    public static void dfs(int Level, String str, int startIdx) {
        if (Level == M) {
            for (char x : str.toCharArray()) {
                sb.append(x + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = startIdx; i < N; i++) {
            dfs(Level + 1, str + (i + 1), i);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dfs(0, "", 0);
        System.out.println(sb);
    }
}
