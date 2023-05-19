import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static int deadLock;
    static int dx = 1, dy = 0;
    static int[][] board = new int[100][100];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int tc = 1; tc <= 10; tc++) {
            int N = Integer.parseInt(br.readLine());

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            deadLock = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (board[i][j] == 1) {
                        check(i, j);
                    }
                }
            }

            System.out.println("#" + tc + " " + deadLock);
        }
    }

    private static void check(int x, int y) {
        int nx, ny;

        while (true) {
            nx = x + dx;
            ny = y + dy;

            if (nx >= 0 && nx < 100 && ny >= 0 && ny < 100) {
                if (board[nx][ny] == 1) break;
                if (board[nx][ny] == 2) {
                    deadLock++;
                    break;
                }
                x = nx;
                y = ny;
            } else {
                break;
            }
        }
    }
}