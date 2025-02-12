import java.util.*;

class Solution {
    
    static int answer;
    static char[][] extendsMap;
    
    public int solution(String[] storage, String[] requests) {
        int extendsHeight = storage.length + 2;
        int extendsWidth = storage[0].length() + 2;
        extendsMap = new char[extendsHeight][extendsWidth];
        
        for (int i = 0; i < extendsHeight; i++) Arrays.fill(extendsMap[i], ' ');
        for (int i = 1; i < extendsHeight - 1; i++) {
            char[] chars = storage[i - 1].toCharArray();
            for (int j = 1; j < extendsWidth - 1; j++) {
                extendsMap[i][j] = chars[j - 1];
            }
        }
        
        answer = 0;
        for (int i = 0; i < requests.length; i++) {
            String command = requests[i];
            if (command.length() > 1) {
                sol(command.charAt(0), 2);
            } else {
                sol(command.charAt(0), 1);
            }
        }
        
        return (extendsHeight - 2) * (extendsWidth - 2) - answer;
    }
    
    private void sol(char container, int commandSize) {
        if (commandSize == 2) {
            for (int i = 1; i < extendsMap.length - 1; i++) {
                for (int j = 1; j < extendsMap[0].length - 1; j++) {
                    if (extendsMap[i][j] == container) {
                        extendsMap[i][j] = ' ';
                        answer++;
                    }
                }
            }
        } else {
            int[] dx = {-1, 0, 1, 0};
            int[] dy = {0, 1, 0, -1};
            int[][] ch = new int[extendsMap.length][extendsMap[0].length];
            Queue<int[]> queue = new LinkedList<>();
            queue.offer(new int[] {0, 0});
            while (!queue.isEmpty()) {
                int[] now = queue.poll();
                int x = now[0];
                int y = now[1];
                ch[x][y] = 1;
                
                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    
                    if (valid(nx, ny) && ch[nx][ny] == 0) {
                        if (extendsMap[nx][ny] == container) {
                            ch[nx][ny] = 1;
                            extendsMap[nx][ny] = ' ';
                            answer++;
                        } else if (extendsMap[nx][ny] == ' ') {
                            ch[nx][ny] = 1;
                            queue.offer(new int[] {nx, ny});
                        }
                    }
                }
            }
            
        }
    }
    
    private boolean valid(int x, int y) {
        return x >= 0 && x < extendsMap.length && y >= 0 && y < extendsMap[0].length;
    }
}