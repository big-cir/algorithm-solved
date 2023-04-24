import java.util.Scanner;

public class Solution {
    public static int[] days = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int i = 1; i <= T; i++) {
            int m1 = sc.nextInt();
            int d1 = sc.nextInt();
            int m2 = sc.nextInt();
            int d2 = sc.nextInt();

            int sum = 0;
            if ( m1 == m2) {
                sum = d2 - d1;
            } else {
                sum = (days[m1] - d1) + d2;
            }

            if (m1 < m2) {
                for (int j = m1 + 1; j < m2; j++) {
                    sum += days[j];
                }
            }

             System.out.print("#" + i + " " + (sum + 1) + "\n");
        }
    }
}
