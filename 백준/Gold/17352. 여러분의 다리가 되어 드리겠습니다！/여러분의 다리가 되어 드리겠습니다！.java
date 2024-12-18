import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static List<List<Integer>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        int[] ch = new int[N + 1];
        StringTokenizer st;
        for (int i = 0; i < N - 2; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            graph.get(v1).add(v2);
            graph.get(v2).add(v1);
        }

        int root = 1;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int now = queue.poll();
            ch[now] = 1;

            for (int next : graph.get(now)) {
                if (ch[next] != 1) {
                    queue.offer(next);
                }
            }
        }

        int con = 0;
        for (int i = 1; i <= N; i++) {
            if (ch[i] == 0) {
                con = i;
                break;
            }
        }

        System.out.println(root + " " + con);
    }
}