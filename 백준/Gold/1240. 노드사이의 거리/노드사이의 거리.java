import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Node {
        int v;
        int cost;

        public Node(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }
    }

    static int[] ch;
    static List<List<Node>> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        ch = new int[N + 1];

        list = new ArrayList<>();
        for (int i = 0; i <= N; i++) list.add(new ArrayList<>());

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            list.get(v1).add(new Node(v2, cost));
            list.get(v2).add(new Node(v1, cost));
        }

        for (int i = 0; i < M; i++) {
            int[] dis = new int[N + 1];
            Arrays.fill(ch, 0);

            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            Queue<Node> queue = new LinkedList<>();
            queue.offer(new Node(v1, 0));
            ch[v1] = 1;

            int answer = 0;
            while (!queue.isEmpty()) {
                Node now = queue.poll();

                if (now.v == v2) break;

                for (Node next : list.get(now.v)) {
                    if (ch[next.v] == 0) {
                        ch[next.v] = 1;
                        queue.offer(next);
                        dis[next.v] += dis[now.v] + next.cost;
                    }
                }
            }

            System.out.println(dis[v2]);
        }
    }
}
