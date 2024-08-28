import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, H;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        arr = new int[H + 1];

        for (int i = 0; i < N; i++) {
            int end = Integer.parseInt(br.readLine());
            if (i % 2 == 0) {
                arr[0]++;
                arr[end]--;
            } else {
                arr[H]--;
                arr[H - end]++;
            }
        }

        for (int i = 1; i <= H; i++) {
            arr[i] += arr[i - 1];
        }

        int min = Integer.MAX_VALUE;
        int answer = 0;
        for (int i = 0; i < H; i++) {
            if (min > arr[i]) {
                min = arr[i];
                answer = 0;
            }

            if (min == arr[i]) answer++;
        }

        System.out.print(min + " " + answer);
    }
}