import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] ch;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        ch = new int[N + 1];
        bf(0, "");
        System.out.print(sb);
    }

    private static void bf(int Level, String str) {
        if (Level == M) {
            sb.append(str).append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (ch[i] == 0) {
                ch[i] = 1;
                bf(Level + 1, str + i + " ");
                ch[i] = 0;
            }
        }
    }
}
