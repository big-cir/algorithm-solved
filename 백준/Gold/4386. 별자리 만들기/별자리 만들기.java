import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int[] unf;
    static double[][] map;

    static class Node implements Comparable<Node> {
        private int v1;
        private int v2;
        private double cost;

        public Node(int v1, int v2, double cost) {
            this.v1 = v1;
            this.v2 = v2;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            if (cost > o.cost) return  1;
            else if (cost < o.cost) return -1;
            return 0;
        }
    }

    public static int Find(int v) {
        if (v == unf[v]) {
            return v;
        }
        return unf[v] = Find(unf[v]);
    }

    private static void Union(int v1, int v2) {
        int fv1 = Find(v1);
        int fv2 = Find(v2);
        if (fv1 != fv2)  unf[fv1] = fv2;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new double[N][2];
        unf = new int[N];
        
        for (int i = 0; i < N; i++) {
            unf[i] = i;
        }

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            map[i][0] = Double.parseDouble(st.nextToken());
            map[i][1] = Double.parseDouble(st.nextToken());
        }

        List<Node> list = new ArrayList<>();
        for (int i = 0; i < N - 1; i++) {
            for (int j = i + 1; j < N; j++) {
                list.add(new Node(i, j,
                        Math.sqrt(
                                (Math.pow(map[i][0] - map[j][0], 2)) +
                                (Math.pow(map[i][1] - map[j][1], 2))
                        )
                ));
            }
        }
        Collections.sort(list);

        double answer = 0.0;
        for (Node nd : list) {
            int fv1 = Find(nd.v1);
            int fv2 = Find(nd.v2);

            if (fv1 != fv2) {
                answer += nd.cost;
                Union(nd.v1, nd.v2);
            }
        }
        
        System.out.println(Math.round(answer * 100) / 100.0);
    }
}
