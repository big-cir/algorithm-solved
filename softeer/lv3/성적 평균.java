import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int[] prefixSum = new int[N + 1];
        prefixSum[1] = arr[1];
        for (int i = 2; i <= N; i++) prefixSum[i] = prefixSum[i - 1] + arr[i];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken());
            System.out.println(String.format("%.2f", (double)(prefixSum[end] - prefixSum[start]) / (double)(end - start)));
        }
    }
}
