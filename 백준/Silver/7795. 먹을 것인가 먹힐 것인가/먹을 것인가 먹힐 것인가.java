import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[] a, b;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int tc = 0; tc < T; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            a = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            b = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            Arrays.sort(b);

            int answer = 0;
            for (int i = 0; i < N; i++) {
                int target = a[i];
                answer += search(target);
            }

            System.out.println(answer);
        }
    }

    private static int search(int target) {
        int lt = 0;
        int rt = M;
        while (lt < rt) {
            int mid = (lt + rt) / 2;
            if (b[mid] < target) {
                lt = mid + 1;
            } else {
                rt = mid;
            }
        }

        return rt;
    }
}
