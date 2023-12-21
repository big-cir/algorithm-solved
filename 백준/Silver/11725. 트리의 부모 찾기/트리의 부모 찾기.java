import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static List<List<Integer>> graph;
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

        int[] answer = new int[N + 1];
        int[] ch = new int[N + 1];
        bfs(1, answer, ch);

        for (int i = 2; i <= N; i++) {
            System.out.println(answer[i]);
        }
    }

    private static void bfs(int vertex, int[] answer, int[] ch) {
        if (ch[vertex] == 1) return;
        else {
            ch[vertex] = 1;
            for (int nextV : graph.get(vertex)) {
                if (ch[nextV] == 0) {
                    answer[nextV] = vertex;
                    bfs(nextV, answer, ch);
                }
            }
        }
    }
}
