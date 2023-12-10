import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int answer = Integer.MAX_VALUE;
        int rt = 0;
        int cnt = 0;
        for (int lt = 0; lt < N; lt++) {
            while (rt < N && cnt < K) {
                if (arr[rt] == 1) cnt++;
                rt++;
            }

            if (cnt == K) {
                answer = Math.min(answer, rt - lt);
            }

            if (arr[lt] == 1) cnt--;
        }
        if (answer == Integer.MAX_VALUE) answer = -1;
        System.out.println(answer);
    }
}