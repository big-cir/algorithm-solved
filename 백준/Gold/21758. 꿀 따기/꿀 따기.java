import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int answer = 0;
        int[] prefixSum = new int[N];
        prefixSum[0] = arr[0];
        for (int i = 1; i < N; i++) {
            prefixSum[i] = prefixSum[i - 1] + arr[i];
        }

        int init = prefixSum[N - 1] - arr[0];
        for (int i = 1; i < N - 1; i++) {
            answer = Math.max(answer, init - arr[i] + prefixSum[N - 1] - prefixSum[i]);
        }

        // mid
        int tmp = 0;
        for (int i = 1; i < N - 1; i++) {
            tmp += arr[i];
        }

        for (int i = 1; i < N - 1; i++) {
            answer = Math.max(answer, tmp + arr[i]);
        }

        // end
        prefixSum = new int[N];
        prefixSum[N - 1] = arr[N - 1];
        for (int i = N - 2; i >= 0; i--) {
            prefixSum[i] = prefixSum[i + 1] + arr[i];
        }

        init = prefixSum[0] - arr[N - 1];
        for (int i = N - 2; i > 0; i--) {
            answer = Math.max(answer, init - arr[i] + prefixSum[0] - prefixSum[i]);
        }

        System.out.println(answer);
    }
}