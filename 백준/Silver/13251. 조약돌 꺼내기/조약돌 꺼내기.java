import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        int[] stone = new int[M];
        double[] per = new double[M];
        int total = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            stone[i] = Integer.parseInt(st.nextToken());
            total += stone[i];
        }
        int K = Integer.parseInt(br.readLine());

        double answer = 0;
        for (int i = 0; i < stone.length; i++) {
            per[i] = 1.0;
            for (int j = 0; j < K; j++) {
                per[i] *= (double) (stone[i] - j) / (total - j);
            }
        }

        for (int i = 0; i < per.length; i++) {
            answer += per[i];
        }
        System.out.println(answer);
    }
}
