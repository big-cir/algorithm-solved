import java.util.Scanner;

public class Solution {

    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {1, 0, -1, 0};

    public static int[][] create(int N) {
        int[][] arr = new int[N][N];
        int x = 0;
        int y = 0;
        int dir = 0;
        int val = 1;
        arr[x][y] = val;

        while (val < N * N) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (nx >= 0 && nx < N && ny >= 0 && ny < N && arr[nx][ny] == 0) {
                arr[nx][ny] = ++val;
                x = nx;
                y = ny;
            } else {
                dir++;
            }

            if (dir == 4) {
                dir = 0;
            }
        }

        return arr;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int i = 1; i <= T; i++) {
            int N = sc.nextInt();

            System.out.println("#" + i);
            int[][] arr = create(N);
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    int val = arr[j][k];
                    System.out.print(val + " ");
                }
                System.out.println();
            }
        }
    }
}
