import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < M; i++) {
            int target = Integer.parseInt(br.readLine());
            int cnt = 0;
            int lt = 0, rt = N - 1;
            int minIdx = N;
            while (lt <= rt) {
                int mid = (lt + rt) / 2;
                if (arr[mid] >= target) {
                    rt = mid - 1;
                    minIdx = Math.min(mid, mid);
                } else lt = mid + 1;
            }

            lt = 0;
            rt = N - 1;
            int maxIdx = N;
            while (lt <= rt) {
                int mid = (lt + rt) / 2;
                if (arr[mid] > target) {
                    rt = mid - 1;
                    maxIdx = Math.min(maxIdx, mid);
                } else {
                    lt = mid + 1;
                }
            }

            System.out.println(maxIdx - minIdx);
        }

    }
}
