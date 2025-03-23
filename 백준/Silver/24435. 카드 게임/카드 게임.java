import java.io.*;
import java.util.*;

public class Main {

    static int[][] arr;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < t; tc++) {
            int N = Integer.parseInt(br.readLine());
            int[] bob = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
            int[] alice = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();

            int bobMin = 0;
            int multi = 1;
            for (int i = 0; i < bob.length; i++) {
                bobMin += bob[i] * multi;
                multi *= 10;
            }

            int bobMax = 0;
            multi = 1;
            for (int i = bob.length - 1; i >= 0; i--) {
                bobMax += bob[i] * multi;
                multi *= 10;
            }

            int[] ch = new int[N];
            answer = 0;
            backtrack(1, 0, bobMin, bobMax, alice, ch);
            System.out.println(answer);
        }
    }

    private static void backtrack(int multi, int value, int bobMin, int bobMax, int[] alice, int[] ch) {
        for (int i = 0; i < alice.length; i++) {
            if (ch[i] == 0) {
                ch[i] = 1;
                int comp = value + alice[i] * multi;
                if (comp < bobMin && comp < bobMax) {
                    answer = Math.max(answer, comp);
                }
                backtrack(multi * 10, comp, bobMin, bobMax, alice, ch);
                ch[i] = 0;
            }
        }
    }
}