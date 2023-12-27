import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] dis;
    static int[] dx = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int[] dy = {-2, -1, 1, 2, 2, 1, -1, -2};
    static List<int[]> target;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dis = new int[N + 1][N + 1];

        st = new StringTokenizer(br.readLine());
        int startX = Integer.parseInt(st.nextToken());
        int startY = Integer.parseInt(st.nextToken());

        target = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int targetX = Integer.parseInt(st.nextToken());
            int targetY = Integer.parseInt(st.nextToken());
            target.add(new int[] {targetX, targetY});
        }

        bfs(startX, startY);
        for (int[] answer : target) {
            System.out.print(dis[answer[0]][answer[1]] - 1 + " ");
        }
    }

    private static void bfs(int startX, int startY) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {startX, startY});
        dis[startX][startY] = 1;

        while (!queue.isEmpty()) {
            int[] curPos = queue.poll();

            for (int i = 0; i < 8; i++) {
                int nx = curPos[0] + dx[i];
                int ny = curPos[1] + dy[i];

                if (canMove(nx, ny)) {
                    dis[nx][ny] = dis[curPos[0]][curPos[1]] + 1;
                    queue.offer(new int[] {nx, ny});
                }
            }
        }
    }

    private static boolean canMove(int nx, int ny) {
        if (nx > 0 && nx <= N && ny > 0 && ny <= N && dis[nx][ny] == 0) {
            return true;
        }
        return false;
    }
}
