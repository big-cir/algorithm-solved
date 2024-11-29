import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long[] arr = new long[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        long lt = 0;
        long rt = arr[N - 1] * M;
        long answer = Long.MAX_VALUE;
        while (lt <= rt) {
            long mid = (lt + rt) / 2;
            long cnt = 0;
            for (int i = 0; i < arr.length; i++) {
                cnt += (mid / arr[i]);
                
                if (cnt >= M) break;
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