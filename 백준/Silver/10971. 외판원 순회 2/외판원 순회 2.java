import java.io.*;
import java.util.*;

public class Main {

    static class Edge implements Comparable<Edge> {
        int v1;
        int cost;

        public Edge(int v1, int cost) {
            this.v1 = v1;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge e) {
            return this.cost - e.cost;
        }
    }

    static long answer;
    static List<List<Edge>> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int cost = Integer.parseInt(st.nextToken());
                if (i == j) continue;
                list.get(i + 1).add(new Edge(j + 1, cost));
            }
        }

        answer = Long.MAX_VALUE;
        for (int i = 1; i <= N; i++) {
            int[] ch = new int[N + 1];
            ch[i] = 1;
            dfs(1, N, i, i, 0, ch);
            ch[i] = 0;
        }

        System.out.println(answer);
    }

    private static void dfs(int depth, int N, int start, int nextV, long sum, int[] ch) {
        if (depth == N) {
            for (Edge now : list.get(nextV)) {
                if (now.v1 == start && now.cost != 0) answer = Math.min(answer, sum + now.cost);
            }

            return;
        }

        for (Edge next : list.get(nextV)) {
            if (next.cost == 0) continue;
            if (ch[next.v1] == 0) {
                ch[next.v1] = 1;
                dfs(depth + 1, N, start, next.v1, sum + next.cost, ch);
                ch[next.v1] = 0;
            }
        }
    }
}