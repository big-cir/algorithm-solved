import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int i = 1; i <= T; i++) {
            int h1 = sc.nextInt();
            int m1 = sc.nextInt();
            int h2 = sc.nextInt();
            int m2 = sc.nextInt();

            int h = h1 + h2;
            int m = m1 + m2;
            if (m >= 60) {
                h++;
                m = 60 - m;
            }
            if (h > 11) h -= 12;
            if (m < 0) m = Math.abs(m);

            System.out.printf("#%d %d %d\n", i, h, m);
        }
    }
}