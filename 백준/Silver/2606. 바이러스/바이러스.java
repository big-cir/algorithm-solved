import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, answer = -1;
    static int[] ch;
    static int[][] graph;

    public static void DFS(int vertex) {
        if (ch[vertex] == 1) return;
        else {
            ch[vertex] = 1;
            answer++;
            for (int i = 1; i <= N; i++) {
                if (graph[vertex][i] == 1 && ch[i] == 0) {
                    DFS(i);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());    // 컴퓨터의 개수
        M = Integer.parseInt(br.readLine());    // 간선

        ch = new int[N + 1];
        graph = new int[N + 1][N + 1];
        for (int i = 1; i <= M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            graph[v1][v2] = 1;
            graph[v2][v1] = 1;
        }

        DFS(1);
        System.out.println(answer);
    }
}