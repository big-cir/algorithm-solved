import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    public static void initData(int[] arr, int N, BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[] A = new int[N];
            int[] B = new int[M];

            initData(A, N, br);
            initData(B, M, br);

            int max = 0;
            if (N < M) {
                for (int j = 0; j <= M - N; j++) {
                    int sum = 0;
                    for (int k = 0; k < N; k++) {
                        sum += A[k] * B[j + k];
                    }
                    max = Math.max(max, sum);
                }
            } else if (N > M) {
                for (int j = 0; j <= N - M; j++) {
                    int sum = 0;
                    for (int k = 0; k < M; k++) {
                        sum += A[j + k] * B[k];
                    }
                    max = Math.max(max, sum);
                }
            } else {
                int sum = 0;
                for (int j = 0; j < N; j++) {
                    sum += A[j] * B[j];
                }
                max = Math.max(max, sum);
            }

            System.out.println("#" + i + " " + max);
        }
    }
}
