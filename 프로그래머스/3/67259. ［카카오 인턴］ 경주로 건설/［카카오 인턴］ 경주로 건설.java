import java.util.*;

class Solution {
    
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    
    static class Move {
        int x;
        int y;
        int dir;
        
        public Move(int x, int y, int dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }
    }
    
    public int solution(int[][] board) {
        return bfs(board);
    }
    
    private int bfs(int[][] board) {
        int n = board.length;
        int m = board[0].length;
        int answer = Integer.MAX_VALUE;
        int[][][] dis = new int[n][m][4];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Arrays.fill(dis[i][j], Integer.MAX_VALUE);
            }
        }
        
        Arrays.fill(dis[0][0], 0);
        Queue<Move> pq = new LinkedList<>();
        for (int i = 0; i < 4; i++) {
            int nx = 0 + dx[i];
            int ny = 0 + dy[i];
            
            if (checkRange(nx, ny, n, m) && board[nx][ny] == 0) {
                pq.offer(new Move(nx, ny, i));
                dis[nx][ny][i] = dis[0][0][i] + 100;
            }
        }
        
        while (!pq.isEmpty()) {
            Move now = pq.poll();
            int x = now.x;
            int y = now.y;
            int cDir = now.dir;
            
            if (x == n - 1 && y == m - 1) {
                // answer = Math.min(answer, cost);
                continue;
            }
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (checkRange(nx, ny, n, m) && board[nx][ny] == 0) {
                    if ((cDir % 2 == 0 && i % 2 == 0) || (cDir % 2 == 1 && i % 2 == 1)) {
                        if (dis[x][y][cDir] + 100 < dis[nx][ny][i]) {
                            dis[nx][ny][i] = dis[x][y][cDir] + 100;
                            pq.offer(new Move(nx, ny, i));  
                        }
                    } else if ((cDir % 2 == 0 && i % 2 == 1) || (cDir % 2 == 1 && i % 2 == 0)) {
                        if (dis[x][y][cDir] + 600 < dis[nx][ny][i]) {
                            dis[nx][ny][i] = dis[x][y][cDir] + 600;
                            pq.offer(new Move(nx, ny, i));  
                        }
                    }
                }
            }
        }
        
        return Math.min(dis[n - 1][m - 1][0], Math.min(dis[n - 1][m - 1][1], Math.min(dis[n - 1][m - 1][2], dis[n - 1][m - 1][3])));
    }
    
    private boolean checkRange(int x, int y, int n, int m) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }
}