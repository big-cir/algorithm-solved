import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int R, C, N;
    static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}}, board;
    static int bom = -1, bomTime = -3;

    public static void bomb(int x, int y) {
        board[x][y] = 0;
        for (int i = 0; i < 4; i++) {
            int nx = x + dir[i][0];
            int ny = y + dir[i][1];

            if (nx >= 0 && nx < R && ny >= 0 && ny < C) {
                if (board[nx][ny] != bomTime) board[nx][ny] = 0;
            }
        }
    }

    public static void solution(int N) {
        int curTime = 0;

        while (curTime++ < N) {
            if (curTime % 2 == 0) {
                // 2초 경과 : 모든 위치 폭탄
                for (int i = 0; i < R; i++) {
                    for (int j = 0; j < C; j++) {
                        if (board[i][j] == -1) {
                            board[i][j] = -2;
                        } else if (board[i][j] == 0){
                            board[i][j] = -1;
                        }
                    }
                }
            } else if (curTime % 2 == 1) {
                for (int i = 0; i < R; i++) {
                    for (int j = 0; j < C; j++) {
                        if (board[i][j] == -2) {
                            board[i][j] = -3;
                        } else if (board[i][j] == -1) board[i][j] = -2;
                    }
                }

                for (int i = 0; i < R; i++) {
                    for (int j = 0; j < C; j++) {
                        if (board[i][j] == bomTime) {
                            bomb(i, j);
                        }
                    }
                }
            }
        }
    }

    // 1. 폭탄 특정 위치 설치
    // 2. 2초 때, 모든 칸에 폭탄 설치
    // 3. 3초 때 폭탄 폭발
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        board = new int[R][C];

        // 1초 경과
        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                if (String.valueOf(str.charAt(j)).equals("O")) board[i][j] = bom;
            }
        }

        solution(N);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (board[i][j] == 0) {
                    sb.append(".");
                } else {
                    sb.append("O");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
