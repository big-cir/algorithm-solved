import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, tmpcheeseCnt, cheeseCnt = Integer.MAX_VALUE;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] ch;
    static int[][] board;
    static List<Point> points;

    public static class Point {
        private final int x;
        private final int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            Point other = (Point) o;
            if (x == other.x && y == other.y) {
                return true;
            }
            return false;
        }
    }

    // ep : 외부 공기를 확인하는 dfs
    public static void dfs(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < N && ny >= 0 && ny < M && board[nx][ny] == 0 && ch[nx][ny] == 0) {
                board[nx][ny] = 2;
                ch[nx][ny] = 1;
                dfs(nx, ny);
            } else if (nx > 0 && nx < N - 1 && ny > 0 && ny < M - 1 && board[nx][ny] == 1 && ch[nx][ny] == 0){
                ch[nx][ny] = 1;
                points.add(new Point(nx, ny));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];
        ch = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        points = new ArrayList<>();
        ArrayList<Integer> size = new ArrayList<>();
        int answer = -1;
        int count = -1;
        while (count != 0) {
            for (int[] x : ch) {
                Arrays.fill(x, 0);
            }
            points.clear();

            ch[0][0] = 1;
            board[0][0] = 2;
            dfs(0, 0);

            count = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    Point checkPoint = new Point(i, j);
                    if (points.contains(checkPoint)) {
                        board[i][j] = 0;
                        count++;
                    }

                    if (board[i][j] == 2) board[i][j] = 0;
                }
            }

            answer++;
            size.add(points.size());
        }

        System.out.println(answer);
        System.out.println(size.get(answer - 1));
    }
}
