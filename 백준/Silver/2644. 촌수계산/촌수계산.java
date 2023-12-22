import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N, M, to, from, answer;
    static List<List<Integer>> graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        to = Integer.parseInt(st.nextToken());
        from = Integer.parseInt(st.nextToken());

        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            graph.get(v1).add(v2);
            graph.get(v2).add(v1);
        }

        int[] ch = new int[N + 1];
        answer = -1;
        dfs(to, from, ch, 0);
        System.out.println(answer);
    }

    private static void dfs(int to, int from, int[] ch, int count) {
        if (to == from) {
            answer = count;
            return;
        }

        ch[to] = 1;
        for (int nextV : graph.get(to)) {
            if (ch[nextV] == 0) {
                dfs(nextV, from, ch, count + 1);
            }
        }
    }
}
