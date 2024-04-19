import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int K, N;
    static int[] lines;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        lines = new int[K];
        for (int i = 0; i < K; i++) {
            lines[i] = Integer.parseInt(br.readLine());
        }

        long max = Long.MIN_VALUE;
        long lt = 0;
        long rt = Long.MAX_VALUE;

        while (lt <= rt) {
            long mid = (lt + rt) / 2;

            if (N <= check(mid)) {
                max = mid;
                lt = mid + 1;
            } else {
                rt  = mid - 1;
            }
        }
        System.out.println(max);
    }

    private static int check(long mid) {
        int cnt = 0;
        for (int i = 0; i < K; i++) {
            cnt += (lines[i] / mid);
        }

        return cnt;
    }
}
