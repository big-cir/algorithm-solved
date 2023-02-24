import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());


        int answer = 0;
        for (int i = 0; i < N; i++) {
            int tmp = i;
            int sum = 0;

            while (tmp != 0) {
                sum = sum + tmp % 10;
                tmp = tmp / 10;
            }

            if (sum + i == N) {
                answer = i;
                break;
            }
        }
        System.out.println(answer);
    }
}
