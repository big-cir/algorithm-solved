import java.io.*;
import java.util.*;

public class Main {

    static final int END_TIME = 3;
    static int N, M, answer;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] map, ch, start;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        start = new int[M][2];
        ch = new int[N][N];
        answer = 0;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            start[i][0] = x;
            start[i][1] = y;
            ch[x][y] = 1;
        }

        int startX = start[0][0];
        int startY = start[0][1];
        dfs(0, 0, startX, startY, map[startX][startY]);
        System.out.println(answer);
    }

    private static void dfs(int time, int pIdx, int x, int y, int sum) {
        if (time == END_TIME) {
            if (pIdx < M - 1) {
                pIdx += 1;
                int[] next = start[pIdx];
                x = next[0];
                y = next[1];
                dfs(0, pIdx, x, y, sum + map[x][y]);
            } else {
                answer = Math.max(answer, sum);
                return;
            }
        
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                if (ch[nx][ny] == 0) {
                    ch[nx][ny] = 1;
                    dfs(time + 1, pIdx, nx, ny, sum + map[nx][ny]);
                    ch[nx][ny] = 0;
                }
            }
        }
    }
}
