import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int i = 1; i <= T; i++) {
            int N = sc.nextInt();
            boolean flag = true;
            boolean find = false;
            int multi = 1;
            int[] ch = new int[10];

            while (flag) {
                int update = N * multi;
                String str = String.valueOf(update);
                char[] chars = str.toCharArray();
                for (int k = 0; k < chars.length; k++) {
                    int idx = chars[k] - 48;
                    ch[idx] = 1;
                }

                for (int j = 0; j < ch.length; j++) {
                    if (ch[j] == 0) {
                        find = false;
                        break;
                    } else {
                        find = true;
                    }
                }

                if (find) {
                    N = update;
                    flag = false;
                }

                multi++;
            }
            System.out.println("#" + i + " " + N);
        }
    }
}
