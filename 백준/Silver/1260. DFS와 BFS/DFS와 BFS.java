import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[][] graph;       // map 표시 배열
    static int[] ch;            // 방문여부 표시 배열
    static int N, M, V;

    public static void DFS(int start_vertex) {
        if (ch[start_vertex] == 1) return;                // 이미 방문한 vertex 이면 메서드 종료
        else {
            ch[start_vertex] = 1;                         // 방문하지 않았다면 방문을 체크
            System.out.print(start_vertex + " ");
            for (int i = 1; i <= N; i++) {          // 방문하지 않은 vertex 를 탐지
                if (graph[start_vertex][i] == 1) {
                    DFS(i);
                }
            }
        }
    }

    public static void BFS(int start_vertex) {
        Arrays.fill(ch, 0);
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start_vertex);
        ch[start_vertex] = 1;

        while (!queue.isEmpty()) {
            int cur = queue.poll();
            System.out.print(cur + " ");
            for (int i = 1; i <= N; i++) {
                if (ch[i] == 0 && graph[cur][i] == 1) {
                    queue.offer(i);
                    ch[i] = 1;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());   // 정점 개수
        M = Integer.parseInt(st.nextToken());   // 간선 개수
        V = Integer.parseInt(st.nextToken());   // 정점 번호

        graph = new int[N + 1][N + 1];
        ch = new int[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            graph[v1][v2] = 1;
            graph[v2][v1] = 1;
        }

        DFS(V);
        System.out.println();
        BFS(V);
    }
}