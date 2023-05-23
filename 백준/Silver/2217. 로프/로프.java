import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N;           // 로프 개수
    static int[] w;         // 로프의 최대 중량

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        w = new int[N];
        for (int i = 0; i < N; i++) {
            w[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(w);

        int max = 0;
        for (int i = 0; i < N; i++) {
            int cur = w[i] * (N - i);
            max = Math.max(max, cur);
        }
        System.out.println(max);
    }
}