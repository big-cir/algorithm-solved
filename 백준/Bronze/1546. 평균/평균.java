import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        double[] A = new double[N];
        double answer = 0;
        double sum = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        double M = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            if (A[i] > M) {
                M = A[i];
            }
        }

        for (int i = 0; i < N; i++) {
            A[i] = A[i] / (M * 100) * 10000;
            sum += A[i];
        }

        answer = sum / N;
        System.out.println(answer);
    }
}
