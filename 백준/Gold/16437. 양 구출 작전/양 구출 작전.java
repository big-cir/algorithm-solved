import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static List<WnS> wns;
    static List<List<Integer>> graph;

    static class WnS {
        int cnt;
        int vertex;

        public WnS(int cnt, int vertex) {
            this.cnt = cnt;
            this.vertex = vertex;
        }

        public void setCnt(int count) {
            this.cnt += count;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        wns = new ArrayList<>();
        wns.add(new WnS(0 ,0));
        for (int i = 2; i <= N; i++) {
            String[] info = br.readLine().split(" ");
            String t = info[0];
            int a = Integer.parseInt(info[1]);
            int p = Integer.parseInt(info[2]);

            if ("S".equals(t)) {
                wns.add(new WnS(a, p));
            } else {
                wns.add(new WnS(-a, p));
            }

            graph.get(p).add(i);
        }

        long answer = getSheep(1);
        System.out.println(answer);
    }

    private static long getSheep(int vertex) {
        long result = 0;
        for (int next : graph.get(vertex)) {
            result += getSheep(next);
        }

        WnS cur = wns.get(vertex - 1);
        result += cur.cnt;

        if (result < 0) return 0;
        return result;
    }
}