import java.util.LinkedList;
import java.util.Queue;

class Solution {
    static int answer;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
    
        answer = 0;
        bfs(0, 0, n, m, maps);
        return answer;
    }
    
    private void bfs(int x, int y, int n, int m, int[][] maps) {
        Queue<int[]> queue = new LinkedList<>();
        int[][] ch = new int[n][m];
        ch[x][y] = 1;
        queue.offer(new int[] {x, y});
        
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            
            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                
                if (isValid(nx, ny, ch) && maps[nx][ny] == 1) {
                    ch[nx][ny] = 1;
                    maps[nx][ny] = maps[now[0]][now[1]] + 1;
                    queue.offer(new int[] {nx, ny});
                }
            }
        }
        
        if (maps[n - 1][m - 1] >= 2) answer = maps[n - 1][m - 1];
        else {
            answer = -1;
        }
    }
    
    private boolean isValid(int nx, int ny, int[][] ch) {
        return nx >= 0 && nx < ch.length && ny >= 0 && ny < ch[0].length && ch[nx][ny] == 0;
    }
}