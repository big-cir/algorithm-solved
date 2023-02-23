import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] D;

    static int fibo(int N) {
        if (D[N] != -1) {
            return D[N];
        } else {
            return D[N] = fibo(N - 2) + fibo(N - 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        D = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            D[i] = -1;
        }

        D[0] = 0;
        D[1] = 1;

        fibo(N);
        System.out.println(D[N]);
    }
}
