import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[] A;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int answer = 0;
        int sum = 0;
        int lt = 0;
        for (int rt = 0; rt < N; rt++) {
            sum += A[rt];
            if (sum == M) answer++;
            while (sum >= M) {
                sum -= A[lt];
                lt++;
                if (sum == M) answer++;
            }
        }
        System.out.println(answer);
    }
}
