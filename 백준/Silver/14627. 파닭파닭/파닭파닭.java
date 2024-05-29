import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int S = info[0];
        int C = info[1];
        int[] gos = new int[S];
        for (int i = 0; i < S; i++) gos[i] = Integer.parseInt(br.readLine());

        long lt = 1;
        long rt = 1000000000; //Arrays.stream(gos).min().getAsInt();
        long max = 0;
        while (lt <= rt) {
            long mid = (lt + rt) / 2;

            int cnt = 0;
            for (int i = 0; i < S; i++) {
                cnt += gos[i] / mid;
            }

            if (cnt < C) {
                rt = mid - 1;
            } else {
                max = mid;
                lt = mid + 1;
            }
        }

        long sum = 0;
        for (int x : gos) sum += x;
        long answer = sum - max * C;
        System.out.println(answer);
    }
}
