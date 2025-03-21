import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int N = input[0];
        int M = input[1];
        long[] times = new long[N];
        for (int i = 0; i < N; i++) times[i] = Long.parseLong(br.readLine());
        long lt = 0;
        long rt = M * Arrays.stream(times).max().getAsLong();
        long answer = Long.MAX_VALUE;
        while (lt <= rt) {
            long mid = (lt + rt) / 2;
            long cnt = 0;
            for (long time : times) {
                cnt += mid / time;
                
                if (cnt > M) break;
            }

            if (cnt < M) {
                lt = mid + 1;
            } else {
                answer = Math.min(answer, mid);
                rt = mid - 1;
            }
        }

        System.out.println(answer);
    }
}
