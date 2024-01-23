import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    private int[] dx = {-1, 0, 1, 0};
    private int[] dy = {0, 1, 0, -1};
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        for (int i = 0; i < places.length; i++) {
            char[][] chars = makeArr(places[i]);
            int cnt = 0;
            boolean flag = true;
            for (int j = 0; j < chars.length; j++) {
                for (int k = 0; k < chars[0].length; k++) {
                    if (chars[j][k] == 'P') {
                        cnt++;
                        if (!bfs(j, k, chars)) {
                            flag = false;
                            break;
                        }
                    }
                }
            }

            if (cnt == 0 || flag) answer[i] = 1;
            else {
                answer[i] = 0;
            }
        }

        return answer;
    }

    private boolean bfs(int x, int y, char[][] chars) {
        int[][] ch = new int[chars.length][chars[0].length];
        Queue<int[]> queue = new LinkedList<>();
        ch[x][y] = 1;
        queue.offer(new int[] {x, y, 0});

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int curDis = now[2];

            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if (isValid(nx, ny, ch) && chars[nx][ny] == 'O') {
                    ch[nx][ny] = 1;
                    queue.offer(new int[] {nx, ny, curDis + 1});
                }

                if (isValid(nx, ny, ch) && chars[nx][ny] == 'P' && curDis < 2) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(int nx, int ny, int[][] ch) {
        return nx >= 0 && nx < 5 && ny >= 0 && ny < 5 && ch[nx][ny] == 0;
    }

    private char[][] makeArr(String[] str) {
        char[][] chars = new char[5][5];
        for (int i = 0; i < 5; i++) {
            chars[i] = str[i].toCharArray();
        }
        return chars;
    }
}