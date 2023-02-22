import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M, answer;
    static int[] A;

    public static int solution(int target) {
        int lt = 0, rt = N - 1;
        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if (target == A[mid]) {
                answer = 1;
                return answer;
            }
            if (target < A[mid]) {
                rt = mid - 1;
            } else {
                lt = mid + 1;
            }
        }
        return answer = 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);

        M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(st.nextToken());
            System.out.println(solution(target));
        }
    }
}