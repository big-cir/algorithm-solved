import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int N;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Main::atoi).toArray();

        System.out.println(solution());
    }

    private static long solution() {
        long answer = 0;
        int[] cnt = new int[100001];
        int rt =  0;
        for (int lt = 0; lt < N; lt++) {
            while (rt < N && cnt[arr[rt]] == 0) {
                if (cnt[arr[rt]] == 0) {
                    cnt[arr[rt]] = 1;
                    rt++;
                }
            }
            answer += rt - lt;
            cnt[arr[lt]] = 0;
        }
        return answer;
    }

    private static int atoi(String str) {
        return Integer.parseInt(str);
    }
}