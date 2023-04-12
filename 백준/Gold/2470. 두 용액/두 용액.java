import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, answer = Integer.MAX_VALUE;
    static int[] A;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);

        int lt = 0;
        int rt = A.length - 1;
        int ans1 = 0, ans2 = 0;
        while (lt < rt) {
            int tmp = A[lt] + A[rt];
            if (Math.abs(tmp) < answer) {
                answer = Math.abs(tmp);
                ans1 = A[lt];
                ans2 = A[rt];
            }

            if (tmp == 0) break;

            if (tmp > 0) {
                rt--;
            } else {
                lt++;
            }
        }
        System.out.println(ans1 + " " + ans2);
    }
}