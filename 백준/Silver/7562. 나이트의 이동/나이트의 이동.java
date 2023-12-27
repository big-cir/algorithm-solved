import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] dx = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int[] dy = {-2, -1, 1, 2, 2, 1, -1, -2};
    static int[][] map, dis;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for (int i = 0; i < tc; i++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int dstX = Integer.parseInt(st.nextToken());
            int dstY = Integer.parseInt(st.nextToken());
            bfs(startX, startY);
            System.out.println(dis[dstX][dstY] - 1);
        }
    }

    private static void bfs(int startX, int startY) {
        dis = new int[N][N];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {startX, startY});
        dis[startX][startY] = 1;

        while (!queue.isEmpty()) {
            int[] curPos = queue.poll();

            for (int i = 0; i < 8; i++) {
                int nx = curPos[0] + dx[i];
                int ny = curPos[1] + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < N && dis[nx][ny] == 0) {
                    dis[nx][ny] = dis[curPos[0]][curPos[1]] + 1;
                    queue.offer(new int[] {nx, ny});
                }
            }
        }
    }
}
