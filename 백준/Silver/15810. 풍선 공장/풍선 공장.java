import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long N = Integer.parseInt(st.nextToken());
        long M = Integer.parseInt(st.nextToken());
        long[] arr = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        long max = Arrays.stream(arr).max().getAsLong();

        long lt = 0;
        long rt = max * M;
        long answer = 0;
        while (lt <= rt) {
            long mid = (lt + rt) / 2;
            long tmp = 0;
            for (long x : arr) {
                tmp += mid / x;
            }

            if (tmp >= M) {
                rt = mid - 1;
                answer = mid;
            } else {
                lt = mid + 1;
            }
        }

        System.out.println(answer);
    }
}