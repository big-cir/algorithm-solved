import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, num1, num2;
    static int[] ch, answer;
    static List<List<Integer>> graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        num1 = Integer.parseInt(st.nextToken());
        num2 = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(br.readLine());

        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            graph.get(v1).add(v2);
            graph.get(v2).add(v1);
        }

        ch = new int[N + 1];
        answer = new int[N + 1];
        bfs();
        System.out.println(answer[num2]);
    }

    public static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(num1);
        ch[num1] = 1;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int x : graph.get(cur)) {
                if (ch[x] == 0) {
                    ch[x] = 1;
                    answer[x] += answer[cur] + 1;
                    if (x == num2) return;
                    queue.offer(x);
                }
            }
        }
       
        if (answer[num2] == 0) answer[num2] = -1;
    }
}
