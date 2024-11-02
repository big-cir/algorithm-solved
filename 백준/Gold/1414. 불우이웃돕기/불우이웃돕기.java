import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static int[] unf;
    static int[][] map;
    static List<Edge> list;

    static class Edge implements Comparable<Edge> {
        int v1;
        int v2;
        int cost;

        public Edge(int v1, int v2, int cost) {
            this.v1 = v1;
            this.v2 = v2;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N + 1][N + 1];
        list = new ArrayList<>();

        int sum = 0;
        for (int i = 1; i <= N; i++) {
            char[] chars = br.readLine().toCharArray();
            for (int j = 1; j <= N; j++) {
                char ch = chars[j - 1];
                if (ch == '0') {
                    map[i][j] = 0;
                } else if (Character.isLowerCase(ch)) {
                    map[i][j] = ch - '0' - 48;
                } else {
                    map[i][j] = ch - '0' + 10;
                }

                int val = map[i][j];
                sum += val;

                if (val == 0) continue;
                list.add(new Edge(i, j, val));
            }
        }
        Collections.sort(list);

        unf = new int[N + 1];
        for (int i = 1; i <= N; i++) unf[i] = i;

        int minSum = 0;
        for (Edge edge : list) {
            int child = edge.v1;
            int parent = edge.v2;

            if (find(child) != find(parent)) {
                union(child, parent);
                minSum += edge.cost;
            }
        }

        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            if (unf[i] == i) cnt++;
        }

        if (cnt >= 2) {
            System.out.println(-1);
            return;
        }

        System.out.println(sum - minSum);
    }

    private static void union(int child, int parent) {
        child = find(child);
        parent = find(parent);
        unf[child] = parent;
    }

    private static int find(int vertex) {
        if (unf[vertex] == vertex) return vertex;
        else return unf[vertex] = find(unf[vertex]);
    }
}