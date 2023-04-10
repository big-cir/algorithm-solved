import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        int M = Integer.parseInt(br.readLine());
        Arrays.sort(A);
        System.out.println(toUpperCase(N, A, M));

    }

    private static int toUpperCase(int n, int[] a, int m) {
        int lt = 0;
        int rt = a[n - 1];

        while (lt <= rt) {
            int sum = 0;
            int mid = (lt + rt) / 2;
            for (int x : a) {
                if (x >= mid) sum += mid;
                else {
                    sum += x;
                }
            }
            if (sum > m) {
                rt = mid - 1;
            } else {
                lt = mid + 1;
            }
        }

        return rt;
    }
}
