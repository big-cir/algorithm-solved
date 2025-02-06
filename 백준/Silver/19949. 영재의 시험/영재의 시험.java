import java.io.*;
import java.util.*;

public class Main {

    static int N, answer;
    static int[] arr, ch;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = arr.length;
        ch = new int[N];
        answer = 0;
        combi(0, 0);
        System.out.println(answer);
    }

    private static void combi(int solve, int score) {
        if (solve >= 7 && score <= 1) return;
        if (solve == N) {
            if (score >= 5) {
                answer++;
            }
            return;
        }

        for (int pick = 1; pick <= 5; pick++) {
            if (!checkValid(solve, pick)) continue;

            int correct = arr[solve];
            ch[solve] = pick;
            if (pick == correct) {
                combi(solve + 1, score + 1);
            } else {
                combi(solve + 1, score);
            }

            ch[solve] = 0;
        }
    }

    private static boolean checkValid(int solve, int pick) {
        if (solve > 1) {
            if (ch[solve - 2] == ch[solve - 1] && ch[solve - 1] == pick) return false;
        }
        return true;
    }
}