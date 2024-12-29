import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[] unf;

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
        public int compareTo(Edge edge) {
            return this.cost - edge.cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            if (N == 0 && M == 0) break;

            List<Edge> list = new ArrayList<>();
            long max = 0;
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int v1 = Integer.parseInt(st.nextToken());
                int v2 = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());
                list.add(new Edge(v1, v2, cost));
                max += cost;
            }
            Collections.sort(list);

            unf = new int[N];
            for (int i = 0; i < N; i++) {
                unf[i] = i;
            }

            List<Edge> mst = new ArrayList<>();
            for (Edge e : list) {
                int child = e.v1;
                int parent = e.v2;

                if (find(child) == find(parent)) continue;
                union(child, parent);
                mst.add(e);
            }

            long dis = 0;
            for (Edge e : mst) {
                dis += e.cost;
            }

            System.out.println(max - dis);
        }
    }

    private static void union(int child, int parent) {
        child = find(child);
        parent = find(parent);
        unf[child] = parent;
    }

    private static int find(int vertex) {
        if (unf[vertex] == vertex) return vertex;
        return unf[vertex] = find(unf[vertex]);
    }
}