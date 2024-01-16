import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int K;
    static List<List<Integer>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());

        for (int i = 0; i < K; i++) {
            graph = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            int vertex = Integer.parseInt(st.nextToken());
            int edge = Integer.parseInt(st.nextToken());

            for (int j = 0; j <= vertex; j++) {
                graph.add(new ArrayList<>());
            }

            for (int j = 0; j < edge; j++) {
                st = new StringTokenizer(br.readLine());
                int v1 = Integer.parseInt(st.nextToken());
                int v2 = Integer.parseInt(st.nextToken());
                graph.get(v1).add(v2);
                graph.get(v2).add(v1);
            }

            boolean flag = true;
            int[] ch = new int[vertex + 1];
            for (int j = 1; j <= vertex; j++) {
                if (ch[j] == 0) {
                    if (!bfs(j, ch)) {
                        flag = false;
                        break;
                    }
                }
            }

            if (flag) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    private static boolean bfs(int start, int[] ch) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        ch[start] = 1;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int next : graph.get(now)) {
                if (ch[next] == 0) {
                    ch[next] = ch[now] * - 1;
                    queue.offer(next);
                } 
                
                if (ch[now] == ch[next]) {
                    return false;
                }
            }
        }
        return true;
    }
}
