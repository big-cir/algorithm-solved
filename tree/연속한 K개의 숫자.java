import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int[] arr = new int[N + 1];
        for (int i = 0; i < B; i++) {
            int x = Integer.parseInt(br.readLine());
            arr[x] = 1;
        }

        int[] sum = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            sum[i] = sum[i - 1] + arr[i];
        }

        int answer = Integer.MAX_VALUE;
        for (int i = 1; i <= N - K + 1; i++) {
            answer = Math.min(answer, sum[i + K - 1] - sum[i]);
        }
        
        System.out.println(answer);
    }
}
