import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(br.readLine());
        Arrays.sort(arr);

        int answer = Integer.MIN_VALUE;
        for (int rt = N - 1; rt >= 2; rt--) {
            int lt = rt - 2;

            if (arr[rt] < arr[lt] + arr[lt + 1]) {
                answer = Math.max(answer, arr[rt] + arr[lt] + arr[lt + 1]);
            }
        }

        System.out.println(answer == Integer.MIN_VALUE ? -1 : answer);
    }
}