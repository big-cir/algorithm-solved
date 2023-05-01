import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] arr, sub;
    static StringBuilder sb = new StringBuilder();

    public static void solution(int Level, int startIdx) {
        if (Level == M) {
            for (int x : sub) {
                sb.append(x).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = startIdx; i < N; i++) {
            sub[Level] = arr[i];
            solution(Level + 1, i + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        sub = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        solution(0, 0);
        System.out.println(sb.toString());
    }
}
