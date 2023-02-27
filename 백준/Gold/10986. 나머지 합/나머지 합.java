import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] A = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        long answer = 0;
        long[] sum = new long[N];
        long[] combi = new long[M];
        sum[0] = A[0];
        for (int i = 0; i < N; i++) {
            if (i > 0) {
                sum[i] = sum[i - 1] + A[i];
            }

            long remainder = sum[i] % M;
            combi[(int)remainder]++;
            if (remainder == 0) {
                answer++;
            }
        }

        for (int i = 0; i < M; i++) {
            if (combi[i] > 1) {
                answer += (combi[i] * (combi[i] - 1) / 2);
            }
        }

        System.out.println(answer);
    }
}
