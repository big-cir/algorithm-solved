import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int lt = 0;
        int rt = Arrays.stream(arr).max().getAsInt();
        int answer = rt;
        while (lt <= rt) {
            int mid = (lt + rt) / 2;

            int cnt = 1;
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < N; i++) {
                min = Math.min(min, arr[i]);
                max = Math.max(max, arr[i]);

                if (max - min > mid) {
                    cnt++;
                    min = arr[i];
                    max = arr[i];
                }
            }

            if (cnt <= M) {
                answer = Math.min(answer, mid);
                rt = mid - 1;
            } else {
                lt = mid + 1;
            }
        }

        System.out.println(answer);
    }
}