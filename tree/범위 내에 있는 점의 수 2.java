import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int MAX = 1000001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        int[] arr = new int[MAX + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int idx = Integer.parseInt(st.nextToken()) + 1;
            arr[idx] = 1;
        }

        int[] sum = new int[MAX + 1];
        for (int i = 1; i < MAX; i++) {
            sum[i] = sum[i - 1] + arr[i];
        }

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken()) + 1;
            int B = Integer.parseInt(st.nextToken()) + 1;

            int answer = sum[B] - sum[A - 1];
            System.out.println(answer);
        }
    }
}
