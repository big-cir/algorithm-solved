import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] board = new int[5][5];
    static StringTokenizer st;

    static boolean validation() {
        int line = 0;

        // 가로
        for (int i = 0; i < 5; i++) {
            int idx = 0;
            boolean flag = false;
            while (true) {
                if (board[i][idx] != 0) break;
                idx++;
                if (idx == 5) {
                    flag = true;
                    break;
                }
            }

            if (flag) line++;
        }

        // 세로
        for (int i = 0; i < 5; i++) {
            int zero = 0;
            for (int j = 0; j < 5; j++) {
                if (board[j][i] != 0) {
                    break;
                } else {
                    zero++;
                }

                if (zero == 5) line++;
            }
        }

        // 대각선
        int zero = 0;
        for (int i = 0; i < 5; i++) {
            if (board[i][i] != 0) break;
            else {
                zero++;
            }

            if (zero == 5) line++;
        }

        zero = 0;
        for (int i = 4; i >= 0; i--) {
            if (board[i][4 - i] != 0) break;
            else {
                zero++;
            }

            if (zero == 5) line++;
        }

        if (line >= 3) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                queue.offer(Integer.parseInt(st.nextToken()));
            }
        }

        int count = 0;
        while (!queue.isEmpty()) {
            int val = queue.poll();
            boolean flag = true;
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (val == board[i][j]) {
                        count++;
                        board[i][j] = 0;
                        flag = false;
                        break;
                    }
                }
                if (!flag) break;
            }

            if (validation()) {
                break;
            }
        }

        System.out.println(count);
    }
}
