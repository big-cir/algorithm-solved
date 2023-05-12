
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();
            int[] A = new int[N + 1], B = new int[N + 1];

            for (int i = 1; i <= N; i++) {
                A[i] = sc.nextInt();
                B[i] = sc.nextInt();
            }

            int P = sc.nextInt();
            int[] C = new int[P + 1];
            int[] answer = new int[P + 1];
            for (int i = 1; i <= P; i++) {
                C[i] = sc.nextInt();

                for (int j = 1; j <= N; j++) {
                    if (C[i] >= A[j] && C[i] <= B[j]) answer[i]++;
                }
            }

            System.out.print("#" + tc + " ");
            for (int i = 1; i <= P; i++) {
                System.out.print(answer[i] + " ");
            }
            System.out.println();
        }
    }
}
