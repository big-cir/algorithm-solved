import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int M, N, H, answer, zeroTomato;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[] dh = {-1, 1};
    static int[][][] map;
    static Queue<int[]> queue = new LinkedList<>();

    public static void bfs() {
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();

            // case1 :
            for (int i = 0; i < 4; i++) {
                int nx = cur[1] + dx[i];
                int ny = cur[2] + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M && map[cur[0]][nx][ny] == 0) {
                    map[cur[0]][nx][ny] = map[cur[0]][cur[1]][cur[2]] + 1;
                    answer = Math.max(answer, map[cur[0]][nx][ny]);
                    zeroTomato--;
                    queue.offer(new int[] {cur[0], nx, ny});
                }
            }
            
            // case2 :
            for (int i = 0; i < 2; i++) {
                int nh = cur[0] + dh[i];

                if (nh >= 0 && nh < H && map[nh][cur[1]][cur[2]] == 0) {
                    map[nh][cur[1]][cur[2]] = map[cur[0]][cur[1]][cur[2]] + 1;
                    answer = Math.max(answer, map[nh][cur[1]][cur[2]]);
                    zeroTomato--;
                    queue.offer(new int[] {nh, cur[1], cur[2]});
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        map = new int[H][N][M];

        // 1 = 익은, 0 = 익지 않은
        zeroTomato = 0;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    int val = Integer.parseInt(st.nextToken());
                    map[i][j][k] = val;
                    if (val == 0) zeroTomato++;
                    if (val == 1) queue.offer(new int[] {i, j, k});
                }
            }
        }

        answer = 0;
        if (zeroTomato == 0) {
            System.out.println("0");
        } else {
            bfs();
            if (zeroTomato == 0) System.out.println(answer - 1);
            else {
                System.out.println("-1");
            }
        }
    }
}