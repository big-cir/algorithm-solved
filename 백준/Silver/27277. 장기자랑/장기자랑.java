import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        if (N == 1) {
            System.out.println(arr[0]);
            return;
        }
        Arrays.sort(arr);

        int[] tmp = new int[N];
        if (N % 2 == 0) {
            int lt = 0;
            int rt = N - 1;
            int idx = 0;
            while (idx < N) {
                if (lt == rt) {
                    tmp[idx++] = arr[rt];
                } else {
                    tmp[idx++] = arr[rt--];
                    tmp[idx++] = arr[lt++];
                }
            }
        } else {
            tmp[0] = arr[N - 1];
            int lt = 0;
            int rt = N - 2;
            int idx = 1;
            while (idx < N) {
                tmp[idx++] = arr[lt++];
                tmp[idx++] = arr[rt--];
            }
        }

        int answer = tmp[0];
        for (int i = 1; i < N; i++) {
            answer += Math.max(0, tmp[i] - tmp[i - 1]);
        }

        System.out.println(answer);
    }
}