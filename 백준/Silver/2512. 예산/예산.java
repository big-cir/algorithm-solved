import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int N, M;
    static int[] payment;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        payment = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        M = Integer.parseInt(br.readLine());

        int answer = 0;
        int lt = 0;
        int rt = Arrays.stream(payment).max().getAsInt();
        while (lt <= rt) {
            int mid = (lt + rt) / 2;

            int tmpSum = 0;
            for (int pay : payment) {
                if (pay <= mid) {
                    tmpSum += pay;
                    continue;
                }
                tmpSum += mid;
            }

            if (tmpSum <= M) {
                answer = mid;
                lt = mid + 1;
            } else {
                rt = mid - 1;
            }
        }
        System.out.println(answer);
    }
}
