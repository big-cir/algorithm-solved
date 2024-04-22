import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int val = 0;
        int[] prefixSum = new int[N];
        for (int i = 0; i < X; i++) {
            val += arr[i];
            prefixSum[i] = val;
        }

        int max = val;
        for (int i = X; i < N; i++) {
            val += arr[i] - arr[i - X];
            prefixSum[i] = val;
            max = Math.max(max, val);
        }

        int cnt = 0;
        for (int x : prefixSum) {
            if (x == max) cnt++;
        }

        if (max == 0) {
            System.out.println("SAD");
            return;
        }

        System.out.println(max);
        System.out.println(cnt);
    }
}