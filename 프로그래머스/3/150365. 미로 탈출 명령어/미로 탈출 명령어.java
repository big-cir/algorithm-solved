class Solution {
    
    static String answer;
    static int[] dx = {1, 0, 0, -1};
    static int[] dy = {0, -1, 1, 0};
    static String[] words = {"d", "l", "r", "u"};
    static int[][] map;
    
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        map = new int[n][m];
        map[x - 1][y - 1] = 2; // start
        map[r - 1][c - 1] = 3; // end
        
        int distance = getDis(x - 1, y - 1, r - 1, c - 1);
        if (distance > k) return "impossible";
        
        answer = "zzzzz";
        backtrack(k, x - 1, y - 1, r - 1, c - 1, new StringBuilder());
        
        if ("zzzzz".equals(answer)) {
            return "impossible";
        }
        
        return answer;
    }
    
    private void backtrack(int k, int x, int y, int r, int c, StringBuilder sb) {
        if (!answer.equals("zzzzz")) return;
        
        if (sb.length() > k) return;
        
        // 도착까지 거리가 주어진 k 보다 큰지 판단
        if (k - sb.length() < getDis(x, y, r, c)) return;
        
        // 남은 거리가 홀수인데 현재 위치에서 도착까지 짝수인 경우
        if ((k - sb.length() - getDis(x, y, r, c)) % 2 != 0) return;
        
        if (sb.length() == k) {
            if (map[x][y] == 3) {
                if (sb.toString().compareTo(answer) < 0) {
                    answer = sb.toString();
                }
            }
            
            return;
        }
        
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if (nx >= 0 && nx < map.length && ny >= 0 && ny < map[0].length) {
                sb.append(words[i]);
                backtrack(k, nx, ny, r, c, sb);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
    
    private int getDis(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }
}