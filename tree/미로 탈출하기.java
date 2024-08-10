import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[] rightX = {0, 1, 0, -1};
    static int[] rightY = {1, 0, -1, 0};
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken()) - 1;
        int y = Integer.parseInt(st.nextToken()) - 1;
        int dir = 1;

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                if (str.charAt(j) == '.') map[i][j] = 1;
                else map[i][j] = 2;
            }
        }

        int answer = 0;
        int boolCnt = 0;
        while (answer < N * N) {
            if (boolCnt >= 4) {
                answer = N * N;
                break;
            }
            answer++;

            int nx = x + dx[dir];
            int ny = y + dy[dir];

            // 진행 방향 앞이 벽인 경우 반시계 90도 회전
            if (nx >= 0 && nx < N && ny >= 0 && ny < N && map[nx][ny] == 2) {
                dir--;
                if (dir < 0) dir = 3;
                answer--;
                boolCnt++;
                continue;
            }

            boolCnt = 0;
            if ((nx < 0 || nx >= N || ny < 0 || ny >= N)) break;

            if (map[nx][ny] == 1) {
                int rx = nx + rightX[dir];
                int ry = ny + rightY[dir];

                if (rx >= 0 && rx < N && ry >= 0 && ry < N && map[rx][ry] == 2) {
                    x = nx;
                    y = ny;
                    continue;
                }

                if (rx >= 0 && rx < N && ry >= 0 && ry < N && map[rx][ry] != 2) {
                    dir++;
                    if (dir == 4) dir = 0;

                    nx += dx[dir];
                    ny += dy[dir];

                    rx = nx + rightX[dir];
                    ry = ny + rightY[dir];

                    if (rx >= 0 && rx < N && ry >= 0 && ry < N && map[rx][ry] == 2) {
                        if (nx >= 0 && nx < N && ny >= 0 && ny < N && map[nx][ny] == 1) {
                            x = nx;
                            y = ny;
                            answer++;
                        }
                    }
                }
            }
        }

        if (answer >= N * N) answer = -1;

        System.out.println(answer);
    }
}
