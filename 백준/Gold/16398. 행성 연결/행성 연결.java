import java.io.*;
import java.util.*;

public class Main {

    static int[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        graph = new int[N][N];
        for (int i = 0; i < N; i++)
            graph[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i <= N; i++) list.add(new ArrayList<>());

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == j) break;
                list.get(i + 1).add(j + 1);
                list.get(j + 1).add(i + 1);
            }
        }

        long answer = 0;
        Queue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int[] ch = new int[N + 1];
        int[] dis = new int[N + 1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[1] = 0;
        pq.offer(new int[] {1, 0});
        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            int n = now[0];
            int cost = now[1];

            if (ch[n] == 1) continue;
            ch[n] = 1;
            answer += cost;

            for (int next : list.get(n)) {
                int nextCost = graph[n - 1][next - 1];
                if (dis[next] > nextCost) {
                    dis[next] = nextCost;
                    pq.offer(new int[] {next, nextCost});
                }
            }
        }

        System.out.println(answer);
    }
}