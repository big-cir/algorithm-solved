import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static List<List<Integer>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int tc = 1;

        StringBuilder sb = new StringBuilder();

        while (true) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            if (N == 0 && M == 0) break;

            graph = new ArrayList<>();
            for (int i = 0; i <= N; i++) {
                graph.add(new ArrayList<>());
            }

            int[] parent = new int[N + 1];
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int v1 = Integer.parseInt(st.nextToken());
                int v2 = Integer.parseInt(st.nextToken());

                graph.get(v1).add(v2);
                graph.get(v2).add(v1);
            }

            int cnt = 0;
            int[] ch = new int[N + 1];
            for (int i = 1; i <= N; i++) {
                if (ch[i] == 0) {
                    int node = 0;
                    int edge = 0;

                    Queue<Integer> queue = new LinkedList<>();
                    queue.offer(i);

                    while (!queue.isEmpty()) {
                        int now = queue.poll();
                        if (ch[now] == 1) continue;
                        ch[now] = 1;
                        node++;

                        for (int next : graph.get(now)) {
                            if (ch[next] == 0) {
                                edge++;
                                queue.offer(next);
                            }
                        }
                    }

                    if (node == edge + 1) cnt++;
                }
            }

            if (cnt == 0) {
                sb.append("Case " + tc + ": No trees.");
            } else if (cnt == 1) {
                sb.append("Case " + tc + ": There is one tree.");
            } else {
                sb.append("Case " + tc + ": A forest of " + cnt + " trees.");
            }
            sb.append("\n");
            tc++;
        }

        System.out.println(sb);
    }
}
