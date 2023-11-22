import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N, max, min;
    static int[] nums, operation;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        operation = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;

        bf(1, nums[0]);
        System.out.println(max);
        System.out.println(min);
    }

    private static void bf(int level, int sum) {
        if (level == N) {
            max = Math.max(max, sum);
            min = Math.min(min, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operation[i] > 0) {
                operation[i]--;
                int nextSum = calculate(sum, nums[level], i);
                bf(level + 1, nextSum);
                operation[i]++;
            }
        }
    }

    private static int calculate(int a, int b, int operator) {
        switch (operator) {
            case 0:
                return a + b;
            case 1:
                return a - b;
            case 2:
                return a * b;
            case 3:
                return a / b;
            default:
                return 0;
        }
    }
}
