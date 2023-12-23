import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static List<List<Integer>> graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            graph.get(v1).add(v2);
            graph.get(v2).add(v1);
        }

        int[] ch = new int[N + 1];
        dfs(0, 1, ch);
        int answer = 0;
        for (int i = 2; i <= N; i++) {
            if (ch[i] == 1) answer++;
        }

        System.out.println(answer);
    }

    private static void dfs(int level, int start, int[] ch) {
        if (level == 2) {
            return;
        } else {
            for (int nextV : graph.get(start)) {
                ch[nextV] = 1;
                dfs(level + 1, nextV, ch);
            }
        }
    }
}
