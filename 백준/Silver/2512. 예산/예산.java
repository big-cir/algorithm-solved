import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M; 
    static int answer;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        M = Integer.parseInt(br.readLine());
        answer = 0;

        Arrays.sort(arr);
        int max = arr[N - 1];

        int lt = 0;
        int rt = max;

        while (lt <= rt) {
            int sum = 0;
            int mid = (lt + rt) / 2;

            for (int x : arr) {
                if (x > mid) {
                    sum += mid;
                    continue;
                }
                sum += x;
            }
            if (sum > M) rt = mid - 1;
            if (sum <= M) lt = mid + 1;
        }
        System.out.println(rt);
    }
}
