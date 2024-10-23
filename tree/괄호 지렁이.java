import java.util.*;
import java.io.*;

public class Main {
    static int N, answer;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] ch;
    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        ch = new int[N][N];

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        answer = 0;
        StringBuilder sb = new StringBuilder();
        sb.append(map[0][0]);
        ch[0][0] = 1;
        dfs(0, 0, sb);
        System.out.println(answer);

    }

    private static void dfs(int x, int y, StringBuilder sb) {
        int size = sb.length();
        if (size % 2 == 0 && size > answer) {
            boolean flag = true;
            for (int i = 0; i < size / 2; i++) {
                if (sb.charAt(i) == '(' && sb.charAt(i + size / 2) == ')') continue;
                flag = false;
            }

            if (flag) {
                answer = Math.max(answer, size);
            }
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                if (ch[nx][ny] == 0) {
                    ch[nx][ny] = 1;
                    sb.append(map[nx][ny]);
                    dfs(nx, ny, sb);
                    ch[nx][ny] = 0;
                    sb.deleteCharAt(sb.length() - 1);
                }
            }
        }
    }
}
