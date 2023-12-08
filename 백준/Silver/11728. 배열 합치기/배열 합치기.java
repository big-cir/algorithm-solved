import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[] A, B;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        B = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        StringBuilder sb = new StringBuilder();
        int aIdx = 0;
        int bIdx = 0;
        int answerIdx = 0;
        while (aIdx < N && bIdx < M) {
            if (A[aIdx] <= B[bIdx]) {
                sb.append(A[aIdx]).append(" ");
                aIdx++;
            } else {
                sb.append(B[bIdx]).append(" ");
                bIdx++;
            }
        }
        while (aIdx < N) sb.append(A[aIdx++]).append(" ");
        while (bIdx < M) sb.append(B[bIdx++]).append(" ");
        System.out.println(sb);
    }
}
