import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {0, 0});
        
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int x = now[0];
            int y = now[1];
            
            if (x == n - 1 && y == m - 1) return maps[n - 1][m - 1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && maps[nx][ny] == 1) {
                    maps[nx][ny] = maps[x][y] + 1;
                    queue.offer(new int[] {nx, ny});
                }
            }
            
        }
        
        return -1;
    }
}