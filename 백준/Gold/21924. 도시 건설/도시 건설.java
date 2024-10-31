import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M;
    static List<List<int[]>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = info[0];
        M = info[1];
        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());

        long total = 0;
        for (int i = 0; i < M; i++) {
            info = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int v1 = info[0];
            int v2 = info[1];
            int cost = info[2];

            graph.get(v1).add(new int[] {v2, cost});
            graph.get(v2).add(new int[] {v1, cost});

            total += cost;
        }

        Queue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        pq.offer(new int[] {1, 0});
        int[] ch = new int[N + 1];

        long cost = 0;
        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            int v = now[0];

            if (ch[v] == 1) continue;
            ch[v] = 1;
            cost += now[1];

            for (int[] next : graph.get(v)) {
                if (ch[next[0]] == 0) {
                    pq.offer(next);
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            if (ch[i] == 0) {
                System.out.println(-1);
                return;
            }
        }

        System.out.println(total - cost);
    }
}