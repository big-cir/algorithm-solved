import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Queue<int[]> waters = new LinkedList<>();
        map = new char[N][M];
        int[] start = new int[2];
        int[] end = new int[2];
        for (int i = 0; i < N; i++) {
            char[] chars = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                char ch = chars[j];
                map[i][j] = ch;
                if (ch == 'S') {
                    start[0] = i;
                    start[1] = j;
                } else if (ch == 'D') {
                    end[0] = i;
                    end[1] = j;
                } else if (ch == '*') {
                    waters.offer(new int[] {i, j});
                }
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {start[0], start[1], 0});
        int answer = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            int size = waters.size();
            while (size > 0) {
                int[] water = waters.poll();
                int waterX = water[0];
                int waterY = water[1];
                for (int i = 0; i < 4; i++) {
                    int waterNx = waterX + dx[i];
                    int waterNy = waterY + dy[i];

                    if (!outOfIndex(waterNx, waterNy)) continue;
                    if (map[waterNx][waterNy] != '.') continue;

                    map[waterNx][waterNy] = '*';
                    waters.add(new int[] {waterNx, waterNy});
                }
                size--;
            }

            size = queue.size();
            while (size > 0) {
                int[] now = queue.poll();
                int x = now[0];
                int y = now[1];
                int cnt = now[2];

                if (map[x][y] == 'D') {
                    answer = Math.min(answer, cnt);
                }

                for (int i = 0; i < 4; i++) {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if (!outOfIndex(nx, ny)) continue;
                    if (!(map[nx][ny] == '.' || map[nx][ny] == 'D')) continue;
                    if (map[nx][ny] != 'D') map[nx][ny] = 'S';
                    queue.offer(new int[] {nx, ny, cnt + 1});
                }
                size--;
            }
        }

        if (answer == Integer.MAX_VALUE) System.out.println("KAKTUS");
        else System.out.println(answer);
    }

    private static boolean outOfIndex(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }
}