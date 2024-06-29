
class Solution {
    static int[] dx = {1, 0, 0, -1};
    static int[] dy = {0, -1, 1, 0};
    static int[][] map;
    static boolean flag;
    static String[] word = {"d", "l", "r", "u"};
    static String answer;
    static StringBuilder sb = new StringBuilder();
    

    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        map = new int[n][m];
        map[x - 1][y - 1] = 2;
        map[r - 1][c - 1] = 3;
        
        answer = "zzzzz";
        
        int distance = calculateDis(x - 1, y - 1, r - 1, c - 1);
        if (distance > k) return "impossible";
        
        flag = false;
        dfs(0, k, x - 1, y - 1, r - 1, c - 1);
        
        return answer.equals("zzzzz") ? "impossible" : answer;
    }
    
    private void dfs(int level, int k, int x, int y, int r, int c) {
        if (!answer.equals("zzzzz")) return;
        
        if ((k - level - calculateDis(x, y, r, c)) % 2!= 0 || k - level < calculateDis(x, y, r, c)) {
            return;
        }
        
        if (sb.length() > k) return;
        
        if (calculateDis(x, y, r, c) > k - sb.length()) return;
        
        if (sb.length() == k && map[x][y] == 3) {
            if (sb.toString().compareTo(answer) < 0) {
                flag = true;
                answer = sb.toString();
            }
            
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < map.length && ny >= 0 && ny < map[0].length) {
                sb.append(word[i]);
                dfs(level + 1, k, nx, ny, r, c);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
    
    private int calculateDis(int x, int y, int r, int c) {
        return Math.abs(x - r) + Math.abs(y - c);
    }
}