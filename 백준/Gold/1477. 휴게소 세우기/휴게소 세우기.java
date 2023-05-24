import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M, L;
    static int[] rest;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        rest = new int[N + 2];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) {
            rest[i] = Integer.parseInt(st.nextToken());
        }
        rest[N + 1] = L;
        Arrays.sort(rest);

        int lt = 1;                     // 최소거리
        int rt = rest[N + 1] - 1;       // 최대거리
        int answer = 0;

        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            int count = 0;

            for (int i = 1; i < rest.length; i++) {
                int gap = rest[i] - rest[i - 1];
                count += (gap - 1) / mid;
            }

            if (count <= M) {
                answer = mid;
                rt = mid - 1;
            } else {
                lt = mid + 1;
            }
        }
        System.out.println(answer);
    }
}
