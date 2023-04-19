import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();


        for (int i = 0; i < T; i++) {
            String str = sc.next();
            StringBuilder sb = new StringBuilder(str);
            sb.reverse();
            
            int answer = 0;
            if (str.equals(sb.toString())) {
                answer = 1;
            }

            System.out.println("#" + (i + 1) + " " + answer);
        }
    }
}