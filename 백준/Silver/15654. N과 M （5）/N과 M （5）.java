import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] arr, sub, ch;
    static StringBuilder sb = new StringBuilder();

    public static void dfs(int Level) {
        if (Level == M) {
            for (int x : sub) {
                System.out.print(x + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < N; i++) {
            if (ch[i] == 0) {
                ch[i] = 1;
                sub[Level] = arr[i];
                dfs(Level + 1);
                ch[i] = 0;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        ch = new int[N];
        sub = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        dfs(0);
        System.out.println(sb);
    }
}
