import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int lt = 1;
        int rt = Arrays.stream(arr).max().getAsInt();
        int answer = 0;
        while (lt <= rt) {
            int mid = (lt + rt) / 2;

            int tmp = 0;
            for (int i = 0; i < N; i++) {
                tmp += (arr[i] / mid);
            }

            if (tmp >= M) {
                answer = Math.max(answer, mid);
                lt = mid + 1;
            } else {
                rt = mid - 1;
            }
        }

        System.out.println(answer);
    }
}
