
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int R, C;
    static int[] answer;
    static int[] dx = {-1 ,0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static char[][] map;
    static int[][] ch;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        ch = new int[R][C];
        for (int i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
        }

        // v, o 일 때 탐색
        answer = new int[2];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (ch[i][j] == 0 && map[i][j] != '#') {
                    bfs(i, j, answer);
                }
            }
        }

        System.out.println(answer[0] + " " + answer[1]);
    }

    private static void bfs(int x, int y, int[] answer) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {x, y});
        ch[x][y] = 1;

        int sheep = 0;
        int wolf = 0;
        if (map[x][y] == 'v') wolf++;
        if (map[x][y] == 'o') sheep++;

        while (!queue.isEmpty()) {
            int[] curPos = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = curPos[0] + dx[i];
                int ny = curPos[1] + dy[i];

                if (nx >= 0 && nx < R && ny >= 0 && ny < C && ch[nx][ny] == 0 && map[nx][ny] != '#') {
                    ch[nx][ny] = 1;
                    if (map[nx][ny] == 'v') wolf++;
                    if (map[nx][ny] == 'o') sheep++;
                    queue.offer(new int[] {nx, ny});
                }
            }
        }

        if (sheep > wolf) answer[0] += sheep;
        else {
            answer[1] += wolf;
        }
    }
}
