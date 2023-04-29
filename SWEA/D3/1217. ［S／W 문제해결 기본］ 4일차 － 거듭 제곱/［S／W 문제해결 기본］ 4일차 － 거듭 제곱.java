import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int i = 1; i <= 10; i++) {
            int T = sc.nextInt();
            int N = sc.nextInt();
            int M = sc.nextInt();

            int answer = (int)Math.pow((double) N, (double) M);
            System.out.println("#" + i + " " + answer);
        }
    }
}
