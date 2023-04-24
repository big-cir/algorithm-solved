import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int i = 1; i <= T; i++) {
            int N = sc.nextInt();
            String str = "";
            int totalCount = 0;

            for (int j = 0; j < N; j++) {
                char ch = sc.next().charAt(0);
                int count = sc.nextInt();
                totalCount += count;

                for (int k = 0; k < count; k++) {
                    str += ch;
                }
            }

            System.out.print("#" + i);
            for (int j = 0; j < totalCount; j++) {
                if (j % 10 == 0) System.out.println();
                System.out.print(str.charAt(j));
            }
            System.out.println();
        }
    }
}
