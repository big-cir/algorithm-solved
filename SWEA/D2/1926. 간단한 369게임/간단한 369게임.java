import java.io.IOException;
import java.util.*;

public class Solution {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int i = 1; i <= T; i++) {
            String sub = String.valueOf(i).replaceAll("[^3|6|9]", "");
            if (sub.length() == 1) {
                System.out.print("- ");
            } else if (sub.length() == 2) {
                System.out.print("-- ");
            } else if (sub.length() == 3) {
                System.out.print("--- ");
            } else {
                System.out.print(i + " ");
            }
        }
    }
}
