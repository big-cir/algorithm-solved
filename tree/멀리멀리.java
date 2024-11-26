import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(arr);

        int lt = 1;
        int rt = arr[N - 1];
        int answer = 0;
        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            int prev = arr[0];
            int cnt = 1;
            for (int i = 1; i < N; i++) {
                int current = arr[i];
                if (current - prev >= mid) {
                    cnt++;
                    prev = current;
                }
            }

            if (cnt >= M) {
                answer = Math.max(answer, mid);
                lt = mid + 1;
            } else {
                rt = mid - 1;
            }
        }

        System.out.println(answer);
    }
}
