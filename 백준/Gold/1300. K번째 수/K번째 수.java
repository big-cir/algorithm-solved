import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        int answer = 0;

        int lt = 1, rt = K;
        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            int find_count = 0;

            for (int i = 1; i <= N; i++) {
                find_count += Math.min(mid / i, N);
            }

            if (find_count < K) {
                lt = mid + 1;
            } else {
                answer = mid;
                rt = mid - 1;
            }
        }
        System.out.println(answer);
    }
}