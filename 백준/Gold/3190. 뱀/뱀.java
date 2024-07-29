import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, K, L, time;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] board;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        board[0][0] = -1;

        K = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            board[x][y] = 1;
        }

        L = Integer.parseInt(br.readLine());
        Map<Integer, String> map = new HashMap<>();
        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            map.put(Integer.parseInt(st.nextToken()), st.nextToken());
        }

        time = 0;
        bfs(map);
        System.out.println(time);
    }

    private static void bfs(Map<Integer, String> map) {
        // x, y, dir
        int[] start = {0, 0, 1};
        List<int[]> snake = new ArrayList<>();
        snake.add(new int[] {0, 0});

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(start);

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int x = now[0];
            int y = now[1];
            int dir = now[2];
            time++;

            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (nx < 0 || nx >= N || ny < 0 || ny >= N || board[nx][ny] == -1) break;

            if (board[nx][ny] == 1) {
                snake.add(new int[] {nx, ny});
            } else {
                if (!snake.isEmpty()) {
                    int[] remove = snake.remove(0);
                    board[remove[0]][remove[1]] = 0;
                }
                snake.add(new int[] {nx, ny});
            }

            board[nx][ny] = -1;

            if (map.containsKey(time)) rotationDir(now, map);

            queue.offer(new int[] {nx, ny, now[2]});
        }
    }

    private static void rotationDir(int[] info, Map<Integer, String> map) {
        String d = map.get(time);
        int curDir = info[2];

        if ("D".equals(d)) {
            curDir++;
            if (curDir >= 4) {
                curDir %= 4;
            }
            info[2] = curDir;
        } else {
            curDir--;
            if (curDir <= -1) {
                curDir += 4;
            }
            info[2] = curDir;
        }
    }
}