import java.util.*;
public class Solution {
    private static final String[] score = {"D0", "C-", "C0", "C+", "B-", "B0", "B+", "A-", "A0", "A+"}; 

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int i = 1; i <= T; i++) {
            int N = sc.nextInt();
            int K = sc.nextInt();

//            Integer[] arr = new Integer[N];
            int[] arr = new int[N];
            int findScore = 0;
            for (int j = 0; j < N; j++) {
                int middleExam = sc.nextInt();
                int finalExam = sc.nextInt();
                int homework = sc.nextInt();

                int total = (middleExam * 35) + (finalExam * 45) + (homework * 20);
                arr[j] = total;

                if (j + 1 == K) {
                    findScore = total;
                }
            }

            Arrays.sort(arr);
            String answer = "";
            for (int j = 0; j < N; j++) {
                if(arr[j] == findScore) {
                    answer = score[j / (N / 10)];
                    break;
                }
            }

            System.out.println("#" + i + " " + answer);
        }
    }
}
