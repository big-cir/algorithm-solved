import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        long[] prefixSum = new long[N + 1];

        prefixSum[1] = arr[0];
        for (int i = 1; i <= N; i++) {
            prefixSum[i] = prefixSum[i - 1] + arr[i - 1];
        }

        long answer = 0;
        for (int i = M; i <= N; i++) {
            answer = Math.max(prefixSum[i] - prefixSum[i - M], answer);
        }
        
        System.out.println(answer);
    }
}
