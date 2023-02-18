import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M, K, answer;
    static int[][] graph, ch;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void DFS(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < N && ny >= 0 && ny < M && graph[nx][ny] == 1 && ch[nx][ny] == 0) {
                graph[nx][ny] = 0;
                ch[nx][ny] = 1;
                DFS(nx, ny);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());   // 배추밭 가로길이
            M = Integer.parseInt(st.nextToken());   // 세로길이
            K = Integer.parseInt(st.nextToken());   // 심어져 있는 위치의 개수

            graph = new int[N][M];
            ch = new int[N][M];
            answer = 0;

            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());
                graph[X][Y] = 1;
            }

            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (graph[j][k] == 1 && ch[j][k] == 0) {
                        answer++;
                        ch[j][k] = 1;
                        graph[j][k] = 0;
                        DFS(j, k);
                    }
                }
            }
            System.out.println(answer);
        }
    }
}
