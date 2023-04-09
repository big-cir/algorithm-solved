import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] board;
    static int N, M, maxCount = Integer.MAX_VALUE;

    private static int getMaxCount(int startX, int startY) {
        int whitechangeCount = 0;
        int blackchangeCount = 0;
        
        if (board[startX][startY] == 1) {
            for (int i = startX; i < 8 + startX; i++) {
                for (int j = startY; j < 8 + startY; j++) {
                    if (i % 2 == 0) {
                        if (j % 2 == 0 && board[i][j] != 1) whitechangeCount++;
                        if (j % 2 == 1 && board[i][j] != 0) whitechangeCount++;
                    }
                    if (i % 2 == 1) {
                        if (j % 2 == 0 && board[i][j] != 0) whitechangeCount++;
                        if (j % 2 == 1 && board[i][j] != 1) whitechangeCount++;
                    }
                }
            }
            blackchangeCount = 64 - whitechangeCount;
            return Math.min(whitechangeCount, blackchangeCount);
        } else {
            for (int i = startX; i < 8 + startX; i++) {
                for (int j = startY; j < 8 + startY; j++) {
                    if (i % 2 == 0) {
                        if (j % 2 == 0 && board[i][j] != 0) blackchangeCount++;
                        if (j % 2 == 1 && board[i][j] != 1) blackchangeCount++;
                    }
                    if (i % 2 == 1) {
                        if (j % 2 == 0 && board[i][j] != 1) blackchangeCount++;
                        if (j % 2 == 1 && board[i][j] != 0) blackchangeCount++;
                    }
                }
            }
            whitechangeCount = 64 - blackchangeCount;
            return Math.min(whitechangeCount, blackchangeCount);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];

        // 1 = W, 0 = B
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                if (str.substring(j, j + 1).equals("W")) {
                    board[i][j] = 1;
                }
            }
        }

        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                maxCount = Math.min(maxCount, getMaxCount(i, j));
            }
        }

        System.out.println(maxCount);
    }
}