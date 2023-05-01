import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] arr, ch;
    static List<String> list = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    public static void solution(int Level, String str) {
        if (Level == M) {
            if (!list.contains(str)) {
                list.add(str);
            }
            return;
        }

        for (int i = 0; i < N; i++) {
            if (ch[i] == 0) {
                ch[i] = 1;
                solution(Level + 1, str + arr[i] + " ");
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

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        solution(0, "");
        for (String x : list) {
            System.out.println(x);
        }
    }
}