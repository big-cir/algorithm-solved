import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static List<List<Integer>> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        for (int i = 0; i <= N; i++) list.add(new ArrayList<>());

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            list.get(v1).add(v2);
            list.get(v2).add(v1);
        }

        int root = 1;
        int[] depth = new int[N + 1];
        int[] parent = new int[N + 1];
        bfs(root, depth, parent);

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            
            while (depth[v1] != depth[v2]) {
                int v1Depth = depth[v1];
                int v2Depth = depth[v2];

                if (v1Depth > v2Depth) {
                    v1 = parent[v1];
                }

                if (v2Depth > v1Depth) {
                    v2 = parent[v2];
                }
            }
            
            while (v1 != v2) {
                v1 = parent[v1];
                v2 = parent[v2];
            }

            System.out.println(v1);
        }
    }

    private static void bfs(int root, int[] depth, int[] parent) {
        int[] ch = new int[N + 1];
        ch[root] = 1;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int next : list.get(now)) {
                if (ch[next] == 0) {
                    ch[next] = 1;
                    depth[next] = depth[now] + 1;
                    parent[next] = now;
                    queue.offer(next);
                }
            }
        }
    }
}
