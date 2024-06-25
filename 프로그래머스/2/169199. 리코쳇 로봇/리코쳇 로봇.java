import java.util.*;

class Solution {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public int solution(String[] board) {
        int n = board.length;
        int m = board[0].length();
        char[][] map = new char[n][m];
        int[] start = new int[2];
        int[] end = new int[2];

        for (int i = 0; i < n; i++) {
            String str = board[i];

            for (int j = 0; j < m; j++) {
                map[i][j] = str.charAt(j);

                if (map[i][j] == 'R') {
                    start[0] = i;
                    start[1] = j;
                }

                if (map[i][j] == 'G') {
                    end[0] = i;
                    end[1] = j;
                }
            }
        }

        return bfs(map, n, m, start, end);
    }

    private int bfs(char[][] map, int n, int m, int[] start, int[] end) {
        int[][] ch = new int[n][m];
        ch[start[0]][start[1]] = 1;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {start[0], start[1], 0});

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            if (now[0] == end[0] && now[1] == end[1]) {
                return now[2];
            }

            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                while (true) {
                    if (nx >= 0 && nx < n && ny >= 0 && ny < m && map[nx][ny] != 'D') {
                        nx += dx[i];
                        ny += dy[i];
                    } else {
                        nx -= dx[i];
                        ny -= dy[i];
                        break;
                    }
                }

                if (ch[nx][ny] == 0) {
                    queue.offer(new int[] {nx, ny, now[2] + 1});
                    ch[nx][ny] = 1;
                }
            }
        }

        return -1;
    }
}