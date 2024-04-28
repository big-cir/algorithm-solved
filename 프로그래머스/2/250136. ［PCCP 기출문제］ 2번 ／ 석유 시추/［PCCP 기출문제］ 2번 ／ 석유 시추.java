import java.util.*;

class Solution {
    
    public int solution(int[][] land) {
        Map<Integer, Integer> map = new HashMap<>();
        int[][] ch = new int[land.length][land[0].length];
        
        int pos = -1;
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[0].length; j++) {
                if (ch[i][j] == 0 && land[i][j] == 1) {
                    map.put(pos, bfs(pos, i, j, land, ch));
                    pos--;
                }
            }
        }
        
        int[] partOil = new int[land[0].length];
        for (int i = 0; i < partOil.length; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < land.length; j++) {
                if (land[j][i] != 0) set.add(land[j][i]);
            }
            
            for (int x : set) {
                partOil[i] += map.get(x);
            }
        }
        
        return Arrays.stream(partOil).max().getAsInt();
    }
    
    private int bfs(int pos, int i, int j, int[][] land, int[][] ch) {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {i, j});
        land[i][j] = pos;
        ch[i][j] = 1;
        
        int cnt = 1;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            
            for (int k = 0; k < 4; k++) {
                int nx = now[0] + dx[k];
                int ny = now[1] + dy[k];
                
                if (nx >= 0 && nx < land.length && 
                    ny >= 0 && ny < land[0].length &&
                    ch[nx][ny] == 0 && land[nx][ny] == 1) {
                    cnt++;
                    ch[nx][ny] = 1;
                    queue.offer(new int[] {nx, ny});
                    land[nx][ny] = pos;
                }
            }
        }
        return cnt;
    }
}