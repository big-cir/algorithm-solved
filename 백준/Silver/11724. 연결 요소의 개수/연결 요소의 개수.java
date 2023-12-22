import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, answer;
    static int[] visit;
    static List<List<Integer>> graph;
    
    public static void main(String[] args) throws IOException {
        graph = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visit = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            graph.get(v1).add(v2);
            graph.get(v2).add(v1);
        }

        answer = 0;
        for (int i = 1; i <= N; i++) {
            if (visit[i] == 0) {
                answer++;
                bfs(i);
            }
        }
        System.out.println(answer);
    }

    public static void bfs(int vertex) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(vertex);
        visit[vertex] = 1;

        while (!queue.isEmpty()) {
            int next = queue.poll();

            for (int x : graph.get(next)) {
                if (visit[x] == 0) {
                    visit[x] = 1;
                    queue.add(x);
                }
            }
        }
    }
}
