import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static List<List<Integer>> tree;
    static int[] dp, arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        tree = new ArrayList<>();
        for (int i = 0; i < N; i++) tree.add(new ArrayList<>());

        for (int i = 1; i < N; i++) {
            int parent = arr[i];
            tree.get(parent).add(i);
        }

        dp = new int[N];
        int root = 0;
        dfs(root);
        System.out.println(dp[0]);
    }

    private static void dfs(int node) {
        List<Integer> now = tree.get(node);
        if (now.size() == 0) {
            return;
        }

        Collections.sort(now, (v1, v2) -> {
            return tree.get(v2).size() - tree.get(v1).size();
        });

        Queue<Integer> pq = new PriorityQueue<>();
        for (int next : now) {
            dfs(next);
            pq.offer(-dp[next]);
        }

        int total = 0;
        int time = 1;
        while (!pq.isEmpty()) {
            int cur = -pq.poll();
            total = Math.max(total, cur + time);
            time++;
        }

        dp[node] = total;
    }
}