import java.util.Scanner;

public class Solution {

    public static int[] solution(int N) {
        int[] answer = new int[5];
        while (N > 1) {
            if (N % 2 == 0) {
                N /= 2;
                answer[0]++;
            } else if (N % 3 == 0) {
                N /= 3;
                answer[1]++;
            } else if (N % 5 == 0) {
                N /= 5;
                answer[2]++;
            } else if (N % 7 == 0) {
                N /= 7;
                answer[3]++;
            } else if (N % 11 == 0) {
                N /= 11;
                answer[4]++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int i = 1; i <= T; i++) {
            int N = sc.nextInt();
            int[] answer = solution(N);

            System.out.print("#" + i + " ");
            for (int x : answer) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
}