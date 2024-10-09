import java.util.*;
import java.io.*;

public class Main {

    static int N, answer, total;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] map, ch;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new int[5][5];
        ch = new int[5][5];
        N = Integer.parseInt(br.readLine());
        total = 25 - N;

        for (int i = 0; i < N; i++) {
            int[] block = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            map[block[0] - 1][block[1] - 1] = -1;
            ch[block[0] - 1][block[1] - 1] = 1;
        }

        answer = 0;
        ch[0][0] = 1;
        ch[4][4] = 1;
        backtrack(0, 0, 4, 4, 1, 1, total / 2 + 1);
        System.out.println(answer);
    }

    private static void backtrack(int ax, int ay, int bx, int by, int acnt, int bcnt, int half) {
        if (acnt > half || bcnt > half) return;

        if (acnt == half) {
            for (int i = 0; i < 4; i++) {
                int nbx = bx + dx[i];
                int nby = by + dy[i];

                if (bcnt == half - 1 && nbx == ax && nby == ay) {
                    answer++;
                    return;
                }

                if (nbx >= 0 && nbx < 5 && nby >= 0 && nby < 5 && map[nbx][nby] == 0
                        && ch[nbx][nby] == 0) {
                    ch[nbx][nby] = 1;
                    backtrack(ax, ay, nbx, nby, acnt, bcnt + 1, half);
                    ch[nbx][nby] = 0;
                }
            }
        } else if (acnt < half) {
            for (int i = 0; i < 4; i++) {
                int nax = ax + dx[i];
                int nay = ay + dy[i];

                if (nax >= 0 && nax < 5 && nay >= 0 && nay < 5 && map[nax][nay] == 0
                        && ch[nax][nay] == 0) {
                    ch[nax][nay] = 1;
                    backtrack(nax, nay, bx, by, acnt + 1, bcnt, half);
                    ch[nax][nay] = 0;
                }
            }
        }
    }
}
