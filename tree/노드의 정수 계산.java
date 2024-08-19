import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static int[] parent, dp, treeValue, ch;
    static List<List<Integer>> tree;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        tree = new ArrayList<>();
        for (int i = 0; i <= N; i++) tree.add(new ArrayList<>());

        StringTokenizer st;
        parent = new int[N + 1];
        treeValue = new int[N + 1];

        int vertex = 2;
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());

            tree.get(p).add(vertex);
            if (t == 1) {
                treeValue[vertex] = a;
            } else {
                treeValue[vertex] = -a;
            }

            parent[vertex++] = p;
        }

        dp = new int[N + 1];
        ch = new int[N + 1];
        int root = 1;
        ch[root] = 1;

        dfs(root);
        System.out.println(dp[root]);
    }

    private static void dfs(int x) {
        for (int next : tree.get(x)) {
            if (ch[next] == 0) {
                ch[next] = 1;
                dfs(next);
            }
        }

        dp[x] = treeValue[x];
        for (int next : tree.get(x)) {
            if (dp[next] > 0) dp[x] += dp[next];
        }
    }
}
