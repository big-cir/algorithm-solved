import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static List<List<Integer>> graph;
    static int N, answer;
    static int[] ch;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        StringTokenizer st;
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            graph.get(v1).add(v2);
            graph.get(v2).add(v1);
        }

        ch = new int[N + 1];
        ch[1] = 1;
        int[] depths = new int[N + 1];
        dfs(1, 0, depths);
        for (int x : depths) answer += x;
        if (answer % 2 == 0) {
            System.out.println("No");
        } else {
            System.out.println("Yes");
        }
    }

    private static void dfs(int vertex, int depth, int[] depths) {
        if (graph.get(vertex).size() == 1) {
            depths[vertex] = depth;
        }


        for (int next : graph.get(vertex)) {
            if (ch[next] == 0) {
                ch[next] = 1;
                dfs(next, depth + 1, depths);
            }
        }
    }
}