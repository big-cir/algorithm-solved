import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static char[][] map;
    static List<int[]> doors, mirrors;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];

        doors = new ArrayList<>();
        mirrors = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            char[] chars = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                char ch = chars[j];
                if (ch == '#') {
                    doors.add(new int[] {i, j});
                } else if (ch == '!') {
                    mirrors.add(new int[] {i, j});
                }
                map[i][j] = ch;
            }
        }
        
        int[][][] ch = new int[N][N][4];
        Queue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
        int[] start = doors.get(0);

        for (int i = 0; i < 4; i++) {
            queue.offer(new int[] {start[0], start[1], 0, i});
        }

        int[] end = doors.get(1);
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curX = cur[0];
            int curY = cur[1];
            int curCnt = cur[2];
            int curDir = cur[3];

            ch[curX][curY][curDir] = 1;

            if (curX == end[0] && curY == end[1]) {
                System.out.println(curCnt);
                return;
            }

            int nx = curX + dx[curDir];
            int ny = curY + dy[curDir];

            if (nx >= 0 && nx < N && ny >= 0 && ny < N && ch[nx][ny][curDir] == 0 && map[nx][ny] != '*') {
                if (map[nx][ny] == '!') {
                    queue.offer(new int[] {nx, ny, curCnt + 1, (curDir + 1) % 4});
                    queue.offer(new int[] {nx, ny, curCnt + 1, (curDir + 3) % 4});
                }
                queue.offer(new int[] {nx, ny, curCnt, curDir});
            }
        }
    }
}