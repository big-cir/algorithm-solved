import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int[] load = new int[N + 2];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            load[i] = Integer.parseInt(st.nextToken());
        }
        load[N + 1] = L;
        Arrays.sort(load);

        int lt = 1;
        int rt = load[N + 1] - 1;
        int answer = 0;
        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            int cnt = 0;

            for (int i = 0; i <= N; i++) {
                int gap = load[i + 1] - load[i];
                cnt += (gap - 1) / mid;
            }

            if (cnt <= M) {
                answer = mid;
                rt = mid - 1;
            } else {
                lt = mid + 1;
            }
        }

        System.out.println(answer);
    }
}