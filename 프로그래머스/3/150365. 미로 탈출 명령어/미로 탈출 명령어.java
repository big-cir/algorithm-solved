
class Solution {
    // u, r, d, l
    // static int[] dx = {-1, 0, 1, 0};
    // static int[] dy = {0, 1, 0, -1};
    static int[] dx = {1, 0, 0, -1};
    static int[] dy = {0, -1, 1, 0};
    static int[][] map;
    // static String[] word = {"u", "r", "d", "l"};
    static String[] word = {"d", "l", "r", "u"};
    static String answer;
    static StringBuilder sb = new StringBuilder();
    static boolean flag;
    
    
    // 출발 2, 도착 3
    // n <= 50, m <= 50, x <= 50, y <= 50, r <= 50, c <= 50

    // (x, y) -> (r, c) 총 k만큼 이동
    // 문자열이 빠른 순서로 탈출 (여기서 검증 해야 함? 속도)
    // 같은 격자 두번 이상 방문 가능.
    
    // 4^50 + string 연산
    // 남은 거리 계산해서 어차피 도착하지 못할거면 진즉에 return?
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        map = new int[n][m];
        map[x - 1][y - 1] = 2;
        map[r - 1][c - 1] = 3;
        
        answer = "zzzzz";
        
        int dis = calculateDis(x - 1, y - 1, r - 1, c - 1);
        if (dis > k) return "impossible";
        
        flag = false;
        dfs(0, k, x - 1, y - 1, r - 1, c - 1);
        return answer.equals("zzzzz") ? "impossible" : answer;
    }
    
    // k = 5
    // (1, 2) (2, 0)  dis = 1 + 2 = 3
    
    // (5 - 3) % 2 = 0 || 5 < 3
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