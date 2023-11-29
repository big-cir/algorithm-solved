import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static int[] bottle;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        bottle = new int[N];
        for (int i = 0; i < N; i++) {
            bottle[i] = Integer.parseInt(br.readLine());
        }
        long max = 0;

        long lt = 0;
        long rt = Integer.MAX_VALUE;
        while (lt <= rt) {
            int cnt = 0;
            long mid = (lt + rt) / 2;

            for (int i = 0; i < N; i++) {
                cnt += (bottle[i] / mid);
            }
            
            if (cnt >= K) {
                lt = mid + 1;
                max = mid;
            } else {
                rt = mid - 1;
            }
        }

        System.out.println(max);
    }
}
