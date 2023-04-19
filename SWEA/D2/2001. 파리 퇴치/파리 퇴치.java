import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    public static int getMax(int x, int y, int M, int[][] board, int sum) {
        for (int i = 0; i < M; i++ ) {
            for (int j = 0; j < M; j++){
                sum += board[i + x][j + y];
            }
        }

        return sum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[][] board = new int[N][N];
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < N; k++) {
                    board[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            int max = Integer.MIN_VALUE;
            for (int j = 0; j <= N - M; j++) {
                for (int k = 0; k <= N - M; k++) {
                    max = Math.max(max, getMax(j, k,  M, board, 0));
                }
            }
            System.out.println("#" + (i + 1) + " " + max);
        }
    }
}
