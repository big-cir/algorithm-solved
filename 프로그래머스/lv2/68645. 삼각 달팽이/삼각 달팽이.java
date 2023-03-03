import java.util.*;
class Solution {
    public static int[] dx = {1, 0, -1};
    public static int[] dy = {0, 1, -1};
    public int[] solution(int n) {
        int[][] board = new int[n][n];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j >= 0; j--) {
                board[i][j] = 0;
            }
        }

        int x = 0;
        int y = 0;
        int direction = 0;
        board[x][y] = 1;
        while (true) {
            if (n == 1) break;
            int nx = x + dx[direction];
            int ny = y + dy[direction];
            if (nx >= 0 && ny >= 0 && nx < n && ny < n && board[nx][ny] == 0 && direction % 3 == 0) {
                board[nx][ny] = board[x][y] + 1;
                x++;
                if (x == n - 1) {
                    direction++;
                } else if (board[nx + 1][ny] != 0) {
                    direction++;
                }
            } else if (nx >= 0 && ny >= 0 && nx < n && ny < n && board[nx][ny] == 0 && direction % 3 == 1) {
                board[nx][ny] = board[x][y] + 1;
                y++;
                if (y == n - 1) {
                    direction++;
                } else if (board[nx][ny + 1] != 0) {
                    direction++;
                }
            } else if (nx >= 0 && ny >= 0 && nx < n && ny < n && board[nx][ny] == 0 && direction % 3 == 2) {
                board[nx][ny] = board[x][y] + 1;
                x--;
                y--;
                if (board[nx - 1][ny - 1] != 0) {
                    direction++;
                    if (direction == 3) direction = 0;
                }
            }

            if (board[nx][ny] == n * (n + 1) / 2) break;
        }

        int idx = 0;
        int[] answer = new int[n * (n + 1) / 2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 0) break;
                answer[idx++] = board[i][j];
            }
        }
        
        return answer;
    }
}