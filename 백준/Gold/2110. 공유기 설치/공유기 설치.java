import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, C;
    static int[] A;

    public static int solution() {
        int lt = 1;
        int rt = A[N - 1] - A[0];

        while (lt <= rt) {
            int cnt = 1;
            int mid = (lt + rt) / 2;
            int tmp = A[0];

            for (int i = 1; i < N; i++) {
                if (A[i] - tmp >= mid) {
                    cnt++;
                    tmp = A[i];
                }
            }

            if (cnt < C) {
                rt = mid - 1;
            } else {
                lt = mid + 1;
            }
        }

        return rt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(A);
        System.out.println(solution());
    }
}