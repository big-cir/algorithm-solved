import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] arr, ch;
    static Set<String> set = new HashSet<>();
    static StringBuilder sb = new StringBuilder();

    public static void solution(int Level, String str, int startIdx) {
        if (Level == M) {
            if (set.contains(str)) return;
            set.add(str);
            sb.append(str).append("\n");
            return;
        }

        for (int i = startIdx; i < N; i++) {
            solution(Level + 1, str + arr[i] + " ", i + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        ch = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        solution(0, "", 0);
        System.out.println(sb.toString());
    }
}