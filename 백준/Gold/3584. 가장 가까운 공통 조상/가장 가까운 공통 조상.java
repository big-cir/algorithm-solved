import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static int[] parents, depth;
    static BufferedReader br;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int answer = solution();
            System.out.println(answer);
        }
    }

    private static int solution() throws IOException {
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        parents = new int[N + 1];
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            parents[child] = parent;
        }

        int root = 0;
        for (int i = 1; i <= N; i++) {
            if (parents[i] == 0) {
                root = i;
                break;
            }
        }
        depth = new int[N + 1];
        updateDepth(root, 0);

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());
        return lca(v1, v2);
    }

    private static void updateDepth(int vertex, int dep) {
        depth[vertex] = dep;
        for (int i = 1; i <= N; i++) {
            if (parents[i] == vertex) {
                updateDepth(i, dep + 1);
            }
        }
    }

    private static int lca(int v1, int v2) {
        while (depth[v1] != depth[v2]) {
            int v1Depth = depth[v1];
            int v2Depth = depth[v2];

            if (v1Depth > v2Depth) {
                v1 = parents[v1];
            } else if (v2Depth > v1Depth) {
                v2 = parents[v2];
            }
        }

        while (v1 != v2) {
            v1 = parents[v1];
            v2 = parents[v2];
        }

        return v1;
    }
}