import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int answer;

    public static void solution(int sum, int K, int[] A, int idx) {
        if (sum == K) {
            answer++;
            return;
        }

        for (int i = idx; i < A.length; i++) {
            solution(sum + A[i], K, A, i + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int[] A = new int[N];

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[j] = Integer.parseInt(st.nextToken());
            }

            answer = 0;
            solution(0, K, A, 0);
            System.out.println("#" + i + " " + answer);
        }
    }
}
