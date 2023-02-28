import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int solution(int N, int M, int[] A) {
        int answer = 0, sum = 0;
        for (int i = 0; i < N; i++) {
            sum = A[i];
            for (int j = 0; j < N; j++) {
                if (i == j) continue;
                sum += A[j];
                if (sum == M) answer++;
                sum -= A[j];
            }
        }

        return answer / 2;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(N, M, A));
    }
}
