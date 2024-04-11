import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

class Solution {
    
    static int n, m;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0 , 1, 0, -1};
    static int[][] map, ch;
    
    public int[] solution(String[] maps) {
        n = maps.length;
        m = maps[0].length();
        map = new int[n][m];
        ch = new int[n][m];
        
        for (int i = 0; i < n; i++) {
            String str = maps[i];
            for (int j = 0; j < m; j++) {
                if (str.charAt(j) == 'X') {
                    map[i][j] = 0;
                    ch[i][j] = 1;
                }
                else map[i][j] = toInt(str.charAt(j));
            }
        }
        
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] != 0 && ch[i][j] == 0) {
                    answer.add(dfs(i, j, map[i][j]));
                }
            }
        }
        Collections.sort(answer);
        
        if (answer.size() == 0) return new int[] {-1};
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
    
    private int dfs(int x, int y, int sum) {
        ch[x][y] = 1;
        int tmp = sum;
        
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if (nx >= 0 && nx < n && ny >= 0 && ny < m && map[nx][ny] != 0 && ch[nx][ny] == 0) {
                tmp += dfs(nx, ny, map[nx][ny]);
            }
        }
        
        return tmp;
    }
    
    private int toInt(char x) {
        return x - '0';
    }
}