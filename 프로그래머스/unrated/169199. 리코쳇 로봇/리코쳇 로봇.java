import java.util.LinkedList;
import java.util.Queue;
class Solution {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] ch;
    static String[][] map;
    static Coordinate start, dst;

    static class Coordinate {
        private int x;
        private int y;
        private int count;

        public Coordinate(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }

    public static void init(String[] board) {
        int row = board.length;
        int col = board[0].length();
        ch = new int[row][col];
        map = new String[row][col];

        start = null;
        dst = null;
        for (int i = 0; i < row; i++) {
            String tmp = board[i];
            for (int j = 0; j < col; j++) {
                String input = String.valueOf(tmp.charAt(j));
                if (input.equals("R")) {
                    start = new Coordinate(i, j, 0);
                } else if (input.equals("G")) {
                    dst = new Coordinate(i, j, 0);
                }
                map[i][j] = input;
            }
        }
    }

    public static int bfs(String[] board) {
        int count = 0;
        Queue<Coordinate> queue = new LinkedList<>();
        ch[start.x][start.y] = 1;
        queue.offer(start);

        while (!queue.isEmpty()) {
            Coordinate now = queue.poll();
            int nowX = now.x;
            int nowY = now.y;

            if (dst.x == nowX && dst.y == nowY) return now.count;

            for (int i = 0; i < 4; i++) {
                int nx = nowX;
                int ny = nowY;

                while (nx >= 0 && nx < board.length && ny >= 0 && ny < board[0].length() &&
                        !map[nx][ny].equals("D")) {
                    nx += dx[i];
                    ny += dy[i];
                }
                nx -= dx[i];
                ny -= dy[i];

                if (ch[nx][ny] == 0) {
                    ch[nx][ny] = 1;
                    queue.offer(new Coordinate(nx, ny, now.count + 1));
                }
            }
        }

        return -1;
    }

    public int solution(String[] board) {
        init(board);
        return bfs(board);
    }
}