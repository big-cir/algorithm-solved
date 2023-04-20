import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int i = 1; i <= T; i++) {
            int N = sc.nextInt();
            int K = sc.nextInt();


            int[][] arr = new int[N][N];
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    arr[j][k] = sc.nextInt();
                }
            }

            int count = 0;
            for (int j = 0; j < N; j++) {
                int length = 0;
                for (int k = 0; k < N; k++) {
                    if (arr[j][k] == 0) {
                        if (length == K) count += 1;
                        length = 0;
                    } else {
                        length += 1;
                    }
                }
                if (length == K) count += 1;
            }

            for (int j = 0; j < N; j++) {
                int length = 0;
                for (int k = 0; k < N; k++) {
                    if (arr[k][j] == 0) {
                        if (length == K) count += 1;
                        length = 0;
                    } else {
                        length += 1;
                    }
                }
                if (length == K) count += 1;
            }

            System.out.println("#" + i + " " + count);
        }
    }
}
