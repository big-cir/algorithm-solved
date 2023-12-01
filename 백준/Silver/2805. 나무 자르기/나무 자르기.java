import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[] height;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        height = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        long answer = 0;
        long lt = 0;
        long rt = Arrays.stream(height).max().getAsInt();
        while (lt <= rt) {
            long mid = (lt + rt) / 2;

            long sum = 0;
            for (int h : height) {
                if (h > mid) {
                    sum += (h - mid);
                }
            }

            if (sum >= M) {
                answer = mid;
                lt = mid + 1;
            } else {
                rt = mid - 1;
            }

        }
        System.out.println(answer);
    }
}
