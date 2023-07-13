import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] parl = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            parl[i] = Integer.parseInt(st.nextToken());
        }

        // answer = 소수의 개수
        int answer = 0;

        for (int x : parl) {
            if (x == 1) continue;
            boolean ch = true;

            for (int i = 2; i <= Math.sqrt(x); i++) {
                if (x % i == 0) ch = false;
            }

            if (ch) answer++;
        }

        System.out.println(answer);
    }
}