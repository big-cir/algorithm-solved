import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static int solution(int N, int[] A) {
        int answer = 0, lt = 1, sum = 0;

        for (int rt = 1; rt <= N; rt++) {
            sum += A[rt];
            if (sum == N) {
                answer++;
            }

            while (sum >= N) {
                sum -= A[lt];
                lt++;

                if (sum == N) {
                    answer++;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            A[i] = i;
        }

        System.out.println(solution(N, A));
    }
}
