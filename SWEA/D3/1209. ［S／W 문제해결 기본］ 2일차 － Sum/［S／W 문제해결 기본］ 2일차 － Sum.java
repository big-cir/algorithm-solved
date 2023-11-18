
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
    static int[][] map = new int[100][100];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int tc = 1; tc <= 10; tc++) {
            int N = Integer.parseInt(br.readLine());
            int answer = 0;
            for (int i  = 0; i < 100; i++) {
                map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }
            answer =
                    Math.max(answer, Math.max(getMaxRow(), Math.max(getMaxColumn(), getMaxDiagonal())));
            System.out.println("#" + N +  " " + answer);
        }
    }

    private static int getMaxRow() {
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            sum = Math.max(sum, Arrays.stream(map[i]).sum());
        }

        return sum;
    }

    private static int getMaxColumn() {
        int sum = 0;
        for (int col = 0; col < 100; col++) {
            int tmp = 0;
            for (int row = 0; row < 100; row++) {
                tmp += map[row][col];
            }
            sum = Math.max(sum, tmp);
        }
        return sum;
    }

    private static int getMaxDiagonal() {
        int diagonal1 = 0;
        for (int i = 0; i < 100; i++) {
            diagonal1 += map[i][i];
        }

        int diagonal2 = 0;
        for (int i = 0; i < 100; i++) {
            diagonal2 = map[i][99 - i];
        }

        return Math.max(diagonal1, diagonal2);
    }
}
