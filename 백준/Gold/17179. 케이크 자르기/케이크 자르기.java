import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int[] arr = new int[M + 1];
        for (int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        arr[M] = L;

        for (int i = 0; i < N; i++) {
            int cut = Integer.parseInt(br.readLine());

            int lt = 0;
            int rt = L;
            int answer = 0;
            while (lt <= rt) {
                int mid = (lt + rt) / 2;
                int prev = 0;
                int cnt = 0;
                for (int j = 0; j < M + 1; j++) {
                    int cutSize = arr[j] - prev;
                    if (cutSize >= mid) {
                        cnt++;
                        prev = arr[j];
                    }
                }

                if (cnt > cut) {
                    answer = Math.max(answer, mid);
                    lt = mid + 1;
                } else {
                    rt = mid - 1;
                }
            }

            System.out.println(answer);
        }
    }
}