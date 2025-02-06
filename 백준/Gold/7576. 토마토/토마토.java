import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[][] map;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        Queue<int[]> queue = new LinkedList<>();
        int[][] ch = new int[N][M];
        int dCnt = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int tomato = Integer.parseInt(st.nextToken());
                map[i][j] = tomato;

                if (tomato == 1) {
                    queue.offer(new int[]{i, j});
                    ch[i][j] = 1;
                }

                if (tomato == 0) dCnt++;
            }
        }

        int answer = 0;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int x = now[0];
            int y = now[1];
            answer = Math.max(answer, map[x][y]);

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (ch[nx][ny] == 0 && map[nx][ny] == 0) {
                        ch[nx][ny] = 1;
                        map[nx][ny] = map[x][y] + 1;
                        queue.offer(new int[] {nx, ny});
                    }
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    answer = 0;
                }

                if (map[i][j] == 1) {
                    dCnt--;
                }
            }
        }

        if (dCnt == 0) {
            System.out.println(0);
        } else {
            System.out.println(answer - 1);
        }
    }

}