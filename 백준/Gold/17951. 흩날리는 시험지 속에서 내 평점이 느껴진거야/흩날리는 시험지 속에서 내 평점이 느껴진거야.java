import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int lt = Arrays.stream(arr).min().getAsInt();
        int rt =  Arrays.stream(arr).sum();
        while (lt <= rt) {
            int mid = (lt + rt) / 2;

            int count = 0;
            int sum = 0;
            for (int i = 0; i < N; i++) {
                sum += arr[i];

                if (sum >= mid) {
                    count++;
                    sum = 0;
                }
            }

            if (count < K) {
                rt = mid - 1;
            } else {
                lt = mid + 1;
            }
        }
        
        System.out.println(rt);
    }
}