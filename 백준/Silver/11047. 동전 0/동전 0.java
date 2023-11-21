import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[] buket;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int answer = 0;
        buket = new int[N];
        for (int i = 0; i < N; i++) {
            buket[i] = Integer.parseInt(br.readLine());
        }

        int idx = N - 1;
        while (M != 0) {
            if (M / buket[idx] == 0) {
                idx--;
                continue;
            }
            int count = M / buket[idx];
            M -= (buket[idx] * count);
            answer += count;
        }

        System.out.println(answer);
    }
}
