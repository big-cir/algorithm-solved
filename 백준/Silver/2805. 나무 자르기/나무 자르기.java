import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static long solution(int[] A, int M) {
        int answer = 0;
        int lt = 0;
        int rt = Arrays.stream(A).max().getAsInt();

        while (lt <= rt) {
            long sum = 0;
            int mid = (lt + rt) / 2;

            for (int i = 0; i < A.length; i++) {
                if (A[i] > mid) {
                    sum += A[i] - mid;
                }
            }

            if (sum >= M) {
                lt = mid + 1;
            } else {
                rt = mid - 1;
            }
        }
        return lt - 1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] A = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);
        System.out.println(solution(A, M));
    }
}
