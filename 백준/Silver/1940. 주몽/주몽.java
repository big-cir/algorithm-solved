import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int solution(int N, int M, int[] A) {
        int sum = 0, lt = 0, answer = 0;

        for (lt = 0; lt < N; lt++) {
            int rt = lt + 1;
            sum = A[lt];

            while (rt < N) {
                sum += A[rt];
                if (sum == M) answer++;
                sum -= A[rt];
                rt++;
            }
        }

        return answer;
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
