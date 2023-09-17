import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] map, dis;

    public static void bfs(int N) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {0, 0});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                    if (dis[nx][ny] > map[nx][ny] + dis[cur[0]][cur[1]]) {
                        dis[nx][ny] = map[nx][ny] + dis[cur[0]][cur[1]];
                        queue.offer(new int[] {nx, ny});
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int tc = 1;

        while (N != 0) {
            map = new int[N][N];
            dis = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < N; i++) {
                Arrays.fill(dis[i], Integer.MAX_VALUE);
            }
            dis[0][0] = map[0][0];
            bfs(N);
            System.out.println("Problem " + tc++ + ": " + dis[N - 1][N - 1]);

            N = Integer.parseInt(br.readLine());
        }
    }
}
