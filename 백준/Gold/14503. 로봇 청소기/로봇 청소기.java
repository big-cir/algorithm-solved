import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, M, answer;
    static int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1}; // 북, 동, 남, 서
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] size = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = size[0];
        M = size[1];
        map = new int[N][M];

        // x, y, dir
        int[] start = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int value = Integer.parseInt(st.nextToken());
                map[i][j] = value;
            }
        }

        answer = 0;
        dfs(start);
        System.out.println(answer);
    }

    private static void dfs(int[] pos) {
        int x = pos[0];
        int y = pos[1];
        int d = pos[2];

        if (map[x][y] == 0) {
            map[x][y] = -1;
            answer++;
        }

        for (int i = 0; i < 4; i++) {
            d = (d + 3) % 4;
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny] == 0) {
                dfs(new int[] {nx, ny, d});
                return;
            }
        }
        
        int dir = (d + 2) % 4;
        int nx = x + dx[dir];
        int ny = y + dy[dir];

        if (nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny] != 1) {
            dfs(new int[]{nx, ny, d});
        }
    }
}
