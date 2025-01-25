import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] lDp = new int[N];
        int[] rDp = new int[N];

        Arrays.fill(lDp, 1);
        for (int i = 0; i < N; i++) {
            int fix = arr[i];
            for (int j = i + 1; j < N; j++) {
                if (arr[j] > fix) {
                    lDp[j] = Math.max(lDp[j], lDp[i] + 1);
                }
            }
        }

        Arrays.fill(rDp, 1);
        for (int i = N - 1; i >= 0; i--) {
            int fix = arr[i];
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] > fix) {
                    rDp[j] = Math.max(rDp[j], rDp[i] + 1);
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < N; i++) {
            answer = Math.max(answer, lDp[i] + rDp[i] - 1);
        }
        System.out.println(answer);
    }

}