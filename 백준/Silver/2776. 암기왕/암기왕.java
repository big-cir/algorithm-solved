import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (T > 0) {
            T--;
            int N = Integer.parseInt(br.readLine());
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            int M = Integer.parseInt(br.readLine());
            int[] arr2 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            Arrays.sort(arr);
            for (int target : arr2) {
                boolean flag = true;
                int lt = 0;
                int rt = N - 1;
                while (lt <= rt) {
                    int mid = (lt + rt) / 2;

                    if (arr[mid] <= target) {
                        if (arr[mid] == target) {
                            flag = false;
                            break;
                        }
                        lt = mid + 1;
                    } else rt = mid - 1;
                }

                if (flag) sb.append("0");
                else sb.append("1");
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
}
