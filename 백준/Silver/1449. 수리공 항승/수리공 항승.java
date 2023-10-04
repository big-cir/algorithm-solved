import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int answer = 0;
        int[] info = new int[1001];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            info[Integer.parseInt(st.nextToken())] = 1;
        }

        for (int i = 0; i <= 1000; i++) {
            if (info[i] == 1) {
                for (int j = i; j < i + L; j++) {
                    if (j <= 1000) info[j] = 2;
                }
                answer++;
            }
        }
        System.out.println(answer);
    }
}
