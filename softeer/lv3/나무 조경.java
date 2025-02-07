import java.io.*;
import java.util.*;

public class Main {
    
    static int N, answer;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] map, ch;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        answer = 0;
        ch = new int[N][N];
        dfs(0, 0);
        System.out.println(answer);
    }

    private static void dfs(int twice, int sum) {
        if (N < 3) {
            if (twice == 2) {
                answer = Math.max(answer, sum);
                return;
            }
        } else {
            if (twice == 4) {
                answer = Math.max(answer, sum);
                return;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int x = i;
                int y = j;

                if (ch[i][j] != 0) continue;
                for (int d = 0; d < 4; d++) {
                    int nx = x + dx[d];
                    int ny = y + dy[d];

                    if (valid(nx, ny) && ch[nx][ny] == 0) {
                        ch[x][y] = 1;
                        ch[nx][ny] = 1;
                        dfs(twice + 1, sum + map[x][y] + map[nx][ny]);
                        ch[x][y] = 0;
                        ch[nx][ny] = 0;
                    }
                }
            }
        }
    }

    private static boolean valid(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < N;
    }
}
