import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);
        int answer = Integer.MAX_VALUE;
        int rt = N - 1;
        for (int lt = N - 1; lt > 0; lt--) {
            int sum = arr[lt];
            while (rt >= 0) {
                sum -= arr[rt];
                if (sum >= M) {
                    answer = Math.min(answer, sum);
                    break;
                }
                sum += arr[rt];
                rt--;
            }
        }
        System.out.println(answer);
    }
}
