import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        int answer = 0;
        for (int i = 0; i < T; i++) {
            String str = sc.next();

            for (int j = 1; j < str.length(); j++) {
                String sub = str.substring(0, j);
                if (sub.equals(str.substring(j, j + sub.length()))) {
                    answer = sub.length();
                    break;
                }
            }
            System.out.println("#" + (i + 1) + " " + answer);
        }
    }
}
