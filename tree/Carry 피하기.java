import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, answer;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(br.readLine());

        answer = 0;
        backtrack(0, 0, 0);
        System.out.println(answer);
    }

    private static void backtrack(int level, int sum, int cnt) {
        answer = Math.max(answer, cnt);
        
        if (level == N) return;

        for (int i = level; i < N; i++) {
            if (checkCarry(arr[i], sum)) {
                backtrack(i + 1, sum + arr[i], cnt + 1);
            }
        }
    }

    private static boolean checkCarry(int num, int sum) {
        int maxLength = String.valueOf(sum).length();
        int numLength = String.valueOf(num).length();

        int compLength = Math.min(maxLength, numLength);
        for (int j = 0; j < compLength; j++) {
            int front = (String.valueOf(sum).charAt(maxLength - 1 - j) - '0');
            int back = (String.valueOf(num).charAt(numLength - 1 - j) - '0');

            if (front + back >= 10)  return false;
        }

        return true;
    }
}
