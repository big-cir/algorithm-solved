import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        long[] xPoint = new long[N + 1];
        long[] yPoint = new long[N + 1];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            xPoint[i] = Integer.parseInt(st.nextToken());
            yPoint[i] = Integer.parseInt(st.nextToken());
        }

        long sum = 0;
        long sum2 = 0;
        xPoint[N] = xPoint[0];
        yPoint[N] = yPoint[0];
        for (int i = 0; i < N; i++) {
            sum += xPoint[i] * yPoint[i + 1];
            sum2 += yPoint[i] * xPoint[i + 1];
        }

        double answer = Math.abs(sum - sum2) / 2.0;
        System.out.printf("%.1f", answer);
    }
}
