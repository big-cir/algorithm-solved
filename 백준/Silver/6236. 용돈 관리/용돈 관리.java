import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[] amount;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        amount = new int[N];
        for (int i = 0; i < N; i++) {
            amount[i] = Integer.parseInt(br.readLine());
        }

        int lt = Arrays.stream(amount).max().getAsInt();
        int rt = Arrays.stream(amount).sum() + 1;
        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            int sum = 0;
            int cnt = 1;

            for (int x : amount) {
                sum += x;
                if (sum > mid) {
                    sum = x;
                    cnt++;
                }
            }

            if (cnt > M) {
                lt = mid + 1;
            } else {
                rt = mid - 1;
            }
        }
        System.out.println(lt);
    }
}
