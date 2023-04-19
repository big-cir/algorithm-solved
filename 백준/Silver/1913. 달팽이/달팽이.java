import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N, find, ansX, ansY;
    static int[][] board;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void solution(int val, int find) {
        int x = 0, y = 0;
        int dir = 0;

        while (val > 1) {
            if (dir == 4) {
                dir = 0;
            }

            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (nx >= 0 && nx < N && ny >= 0 && ny < N && board[nx][ny] == 0) {
                board[nx][ny] = --val;
                if (find == board[0][0]) {
                    ansX = 1;
                    ansY = 1;
                }
                if (val == find) {
                    ansX = nx + 1;
                    ansY = ny + 1;
                }
                x = nx;
                y = ny;
            } else {
                dir++;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        find = Integer.parseInt(br.readLine());
        board = new int[N][N];
        int val = N * N;
        board[0][0] = val;
        solution(val, find);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(board[i][j]).append(" ");
            }
            sb.append("\n");
        }
        sb.append(ansX).append(" ").append(ansY);
        System.out.println(sb);
    }
}
