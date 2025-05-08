import java.util.*;

class Solution {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    
    public int[] solution(String[][] places) {
        int n = places.length;
        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            String[] place = places[i];
            int m = place.length;
            
            List<int[]> pos = new ArrayList<>();
            char[][] board = new char[m][place[0].length()];
            for (int j = 0; j < m; j++) {
                board[j] = place[j].toCharArray();
                
                for (int k = 0; k < place[j].length(); k++) {
                    if (board[j][k] == 'P') pos.add(new int[] {j, k});
                }
            }
            
            boolean flag = true;
            for (int j = 0; j < pos.size() - 1; j++) {
                int[] start = pos.get(j);
                
                if (!flag) break;
                
                for (int k = j + 1; k < pos.size(); k++) {
                    int[] dst = pos.get(k);
                    if (!isManhattanDis(start, dst)) {
                        if (!bfs(start, dst, board)) {
                            flag = false;
                            break;
                        }
                    }
                }
            }

            if (flag) answer[i] = 1;
        }
        
        return answer;
    }
    
    private boolean isManhattanDis(int[] start, int[] dst) {
        return Math.abs(start[0] - dst[0]) + Math.abs(start[1] - dst[1]) > 2;
    }
    
    private boolean bfs(int[] start, int[] dst, char[][] board) {
        int[][] ch = new int[board.length][board[0].length];
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {start[0], start[1], 0});
        ch[start[0]][start[1]] = 1;
        
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int x = now[0];
            int y = now[1];
            int dis = now[2];
            
            if (x == dst[0] && y == dst[1]) {
                if (dis <= 2) return false;
                break;
            }
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (isValid(nx, ny) && ch[nx][ny] == 0 &&  (board[nx][ny] == 'O' || board[nx][ny] == 'P')) {
                    ch[nx][ny] = 1;
                    queue.offer(new int[] {nx, ny, dis + 1});
                }
            }
        }
        
        return true;
    }
    
    private boolean isValid(int x, int y) {
        return x >= 0 && x < 5 && y >= 0 && y < 5;
    }
}