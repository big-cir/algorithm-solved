import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] A = new int[K];
        for (int i = 0; i < K; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }

        long lt = 1;
        long rt = Arrays.stream(A).max().getAsInt();

        while (lt <= rt) {
            int count = 0;
            long mid = (lt + rt) / 2;

            for (int i = 0; i < K; i++) {
                count += (A[i] / mid);
            }

            if (count < N) {
                rt = mid - 1;
            } else {
                lt = mid + 1;
            }
        }

        System.out.println(rt);
    }
}
