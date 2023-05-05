import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static List<List<Integer>> graph;
    public static int[] ch, parent;

    public static void bfs(int vertex) {
        Queue<Integer> queue = new LinkedList<>();
        ch[vertex] = 1;
        queue.offer(vertex);

        while (!queue.isEmpty()) {
            int currentV = queue.poll();

            for (int x : graph.get(currentV)) {
                if (ch[x] == 0) {
                    ch[x] = 1;
                    parent[x] = currentV;
                    queue.offer(x);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());        // 노드 개수
        ch = new int[N + 1];
        parent = new int[N + 1];

        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            graph.get(v1).add(v2);
            graph.get(v2).add(v1);
        }

        bfs(1);

        for (int x : parent) {
            if (x == 0) continue;
            System.out.println(x);
        }
    }
}
