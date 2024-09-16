import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M, R;
    static int[] item;
    static List<List<int[]>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = info[0];
        M = info[1];
        R = info[2];

        item = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());

        StringTokenizer st;
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph.get(v1).add(new int[] {v2, cost});
            graph.get(v2).add(new int[] {v1, cost});
        }

        int answer = 0;
        for (int i = 1; i <= N; i++) {
            int[] dis = dijk(i);
            int tmp = 0;
            for (int j = 1; j <= N; j++) {
                if (dis[j] <= M) {
                    tmp += item[j - 1];
                }
            }

            answer = Math.max(tmp, answer);
        }

        System.out.println(answer);
    }

    private static int[] dijk(int start) {
        int[] dis = new int[N + 1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[start] = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        
        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int[] next : graph.get(now)) {
                if (dis[next[0]] > dis[now] + next[1]) {
                    dis[next[0]] = dis[now] + next[1];

                    if (dis[next[0]] <= M) {
                        queue.offer(next[0]);
                    }
                }
            }
        }

        return dis;
    }
}