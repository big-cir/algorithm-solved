import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, V;
    static int[] ch;
    static ArrayList<ArrayList<Integer>> graph;
    static Queue<Integer> queue;

    public static void DFS(int vertex) {
        if (ch[vertex] == 1) {
            return;
        } else {
            ch[vertex] = 1;
            System.out.print(vertex + " ");
            for (int i = 0; i < graph.get(vertex).size(); i++) {
                int cur = graph.get(vertex).get(i);
                if (ch[cur] == 0) {
                    DFS(cur);
                }
            }
        }
    }

    public static void BFS(int vertex) {
        ch[vertex] = 1;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            System.out.print(cur + " ");

            for (int i = 0; i < graph.get(cur).size(); i++) {
                int next_vertex = graph.get(cur).get(i);
                if (ch[next_vertex] == 0) {
                    ch[next_vertex] = 1;
                    queue.offer(next_vertex);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        ch = new int[N + 1];
        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            graph.get(v1).add(v2);
            graph.get(v2).add(v1);
        }

        // 번호가 작은 것 부터 방문 -> 오름차순 정렬
        for (List<Integer> list : graph) {
            Collections.sort(list);
        }

        DFS(V);
        System.out.println();

        Arrays.fill(ch, 0);
        queue = new LinkedList<>();
        queue.offer(V);
        BFS(V);
    }
}
