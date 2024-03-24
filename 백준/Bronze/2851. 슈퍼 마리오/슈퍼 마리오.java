import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Function;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Function<String, Integer> input = Integer::parseInt;

        int[] arr = new int[10];
        int min = 100;
        int answer = 0;
        for (int i = 0; i < 10; i++) {
            if (i != 0) {
                arr[i] = arr[i - 1] + input.apply(br.readLine());
            } else arr[i] = input.apply(br.readLine());

            if (Math.abs(arr[i] - 100) <= min) {
                min = Math.abs(arr[i] - 100);
                answer = arr[i];
            }
        }
        System.out.println(answer);
    }
}
