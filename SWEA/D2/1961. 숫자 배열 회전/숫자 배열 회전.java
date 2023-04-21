import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    private static int[][] board;

    public static int[][] rotation(int N, int[][] board) {
        int[][] tmpBoard = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                tmpBoard[i][j] = board[N - 1 - j][i];
            }
        }
        return tmpBoard;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            int N = Integer.parseInt(br.readLine());
            board = new int[N][N];

            for (int j = 0; j < N; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int k = 0; k < N; k++) {
                    board[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            int[][] copyBoard = rotation(N, board);
            int[][] copyBoard2 = rotation(N, copyBoard);
            int[][] copyBoard3 = rotation(N, copyBoard2);

            System.out.println("#" + i);
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    System.out.print(copyBoard[j][k]);
                }
                System.out.print(" ");

                for (int k = 0; k < N; k++) {
                    System.out.print(copyBoard2[j][k]);
                }
                System.out.print(" ");

                for (int k = 0; k < N; k++) {
                    System.out.print(copyBoard3[j][k]);
                }
                System.out.println();
            }
        }
    }
}
