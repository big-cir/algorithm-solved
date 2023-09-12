import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, zeroTomato, answer = 0;
    static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
    static int[][] map;
    static Queue<int[]> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        queue = new LinkedList<>();
        zeroTomato = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int val = Integer.parseInt(st.nextToken());
                map[i][j] = val;
                if (val == 1) queue.offer(new int[] {i, j});
                if (val == 0) zeroTomato++;
            }
        }

        if (zeroTomato == 0) {
            System.out.println("0");
        } else {
            bfs();
            if (zeroTomato != 0) {
                System.out.println("-1");
            } else {
                System.out.println(answer - 1);
            }
        }
    }

    private static void bfs() {
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny] == 0) {
                    map[nx][ny] = map[cur[0]][cur[1]] + 1;
                    answer = Math.max(answer, map[nx][ny]);
                    zeroTomato--;
                    queue.offer(new int[] {nx, ny});
                }
            }
        }
    }
}
