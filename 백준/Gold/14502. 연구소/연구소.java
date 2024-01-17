import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M, answer;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        answer = 0;
        for (int i = 0; i < N; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        backtrack(0, 0, 0);
        System.out.println(answer);
    }

    private static void backtrack(int x, int y, int count) {
        if (count == 3) {
            int[][] copy = new int[N][M];
            for (int i = 0; i < N; i++) {
                copy[i] = map[i].clone();
            }

            // 확산
            int[][] ch = new int[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (ch[i][j] == 0 && copy[i][j] == 2) {
                        bfs(i, j, copy, ch);
                    }
                }
            }

            // 안전공간 개수 구하기
            int tmp = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (copy[i][j] == 0) tmp++;
                }
            }
            
            answer = Math.max(answer, tmp);
            return;
        }

        // 백트래킹
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    backtrack(i, j, count + 1);
                    map[i][j] = 0;
                }
            }
        }
    }

    private static void bfs(int x, int y, int[][] arr, int[][] ch) {
        ch[x][y] = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {x, y});

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M && ch[nx][ny] == 0 && arr[nx][ny] == 0) {
                    ch[nx][ny] = 1;
                    arr[nx][ny] = 2;
                    queue.offer(new int[] {nx, ny});
                }
            }
        }
    }
}