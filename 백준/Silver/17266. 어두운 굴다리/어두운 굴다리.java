import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N, M;
    static int[] pos;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        pos = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int answer = 0;
        int lt = 0;
        int rt = Integer.MAX_VALUE;
        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            int leftOfPosition = 0;
            for (int i = 0; i < M; i++) {
                int position = pos[i];
                if (leftOfPosition + mid < position) {
                    break;
                }

                leftOfPosition = position + mid;
            }

            if (leftOfPosition >= N) {
                rt = mid - 1;
                answer = mid;
            } else {
                lt = mid + 1;
            }
        }
        System.out.println(answer);
    }
}
