import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] A;

    public static int startIndex(int n) {
        int lt = 0;
        int rt = A.length - 1;

        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if (n > A[mid]) {
                lt = mid + 1;
            } else {
                rt = mid - 1;
            }
        }
        return rt;
    }

    public static int endIndex(int n) {
        int lt = 0;
        int rt = A.length - 1;
        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if (n >= A[mid]) {
                lt = mid + 1;
            } else {
                rt = mid - 1;
            }
        }
        return rt;
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

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int number = Integer.parseInt(st.nextToken());
            sb.append(endIndex(number) - startIndex(number)).append(" ");
        }
        System.out.println(sb.toString());
    }
}
