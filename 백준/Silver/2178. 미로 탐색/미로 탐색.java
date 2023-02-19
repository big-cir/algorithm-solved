import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, answer;
    static int[][] graph, dis;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void BFS(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(x, y));
        graph[x][y] = 0;

        while (!queue.isEmpty()) {
            Point cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx >= 1 && nx <= N && ny >= 1 && ny <= M && graph[nx][ny] == 1) {
                    graph[nx][ny] = 0;
                    queue.offer(new Point(nx, ny));
                    dis[nx][ny] = dis[cur.x][cur.y] + 1;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dis = new int[N + 1][M + 1];
        graph = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            String str = br.readLine(); // index 0 ~ 5
            for (int j = 1; j <= M; j++) {
                graph[i][j] = Integer.parseInt(str.substring(j - 1, j));
            }
        }

        BFS(1, 1);
        if (dis[N][M] != 0) {
            answer = dis[N][M] + 1;
            System.out.println(answer);
        }
    }
}
