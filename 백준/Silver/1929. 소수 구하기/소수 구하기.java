import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] ch;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        ch = new int[N + 1];

        for (int i = 2; i <= N; i++) {
            if (ch[i] == 0) {
                if (i >= M) {
                    System.out.println(i);
                }
                for (int j = i; j <= N; j += i) {
                    ch[j] = 1;
                }
            }
        }
    }
}
