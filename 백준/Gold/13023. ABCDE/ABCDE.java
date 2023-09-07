import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static boolean flag = false;
    static int[] ch;
    static List<List<Integer>> map;

    public static void dfs(int Level, int v) {
        if (Level == 5) {
            flag = true;
            return;
        }

        for (int x : map.get(v)) {
            if (ch[x] == 0) {
                ch[x] = 1;
                dfs(Level + 1, x);
                ch[x] = 0;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new ArrayList<>();
        ch = new int[N];

        for (int i = 0; i < N; i++) {
            map.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            map.get(v1).add(v2);
            map.get(v2).add(v1);
        }

        for (int i = 0; i < map.size(); i++) {
            ch[i] = 1;
            dfs(1, i);
            ch[i] = 0;
            if (flag) break;
        }

        System.out.println(flag ? "1" : "0");
    }
}
