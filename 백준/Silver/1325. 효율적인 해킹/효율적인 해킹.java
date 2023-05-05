import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, max;
    static List<List<Integer>> graph = new ArrayList<>();
    static int[] count;

    public static void bfs(int vertex) {
        int visitCount = 0;
        int[] ch = new int[N + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(vertex);
        ch[vertex] = 1;

        while (!queue.isEmpty()) {
            int currentV = queue.poll();
            for (int x : graph.get(currentV)) {
                if (ch[x] == 0) {
                    ch[x] = 1;
                    queue.offer(x);
                    visitCount++;
                }
            }
        }

        count[vertex] = visitCount;
        max = Math.max(max, visitCount);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        count = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            graph.get(v2).add(v1);
        }

        max = 0;
        for (int i = 1; i <= N; i++) {
            bfs(i);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < count.length; i++) {
            if (max == count[i]) {
                sb.append(i).append(" ");
            }
        }
        System.out.println(sb.toString());
    }
}
