import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static int[] ch, A;
    static Set<Integer> set;

    public static void DFS(int Level, int tmp) {
        if (Level == 3) {
            if (tmp <= M) {
                set.add(tmp);
            }
            return;
        }
        for (int i = 0; i < N; i++) {
            if (ch[i] == 0) {
                ch[i] = 1;
                DFS(Level + 1, tmp + A[i]);
                ch[i] = 0;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N];
        ch = new int[N + 1];
        set = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int tmp = 0;
        DFS(0, 0);
        System.out.println(Arrays.stream(set.stream().mapToInt(Integer::intValue).toArray()).max().getAsInt());
    }
}