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
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        long answer = 0;
        long count = 1;
        int prev = arr[0];
        for (int i = 1; i < arr.length; i++) {
            int next = arr[i];
            if (prev < next) {
                count++;
            } else {
                answer += ((count + 1) * count) / 2;
                count = 1;
            }

            prev = next;
        }

        answer += ((count + 1) * count) / 2;
        System.out.println(answer);
    }
}
