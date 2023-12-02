import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N, X;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        X = Integer.parseInt(br.readLine());

        Arrays.sort(arr);
        int count = 0;
        int lt = 0;
        int rt = N - 1;
        while (lt < rt) {
            int sum = arr[lt] + arr[rt];
            if (sum < X) {
                lt++;
            }

            if (sum >= X) {
                if (sum == X) {
                    count++;
                }
                rt--;
            }
        }
        
        System.out.println(count);
    }
}
