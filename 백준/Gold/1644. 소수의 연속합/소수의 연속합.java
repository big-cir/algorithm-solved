import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int target = Integer.parseInt(br.readLine());
        int[] arr = getPrimeNums(target);

        int lt = 0;
        int rt = 0;
        int sum = 0;
        int answer = 0;
        while (lt <= rt && rt < arr.length) {
            sum += arr[rt];
            if (sum <= target) {
                if (sum == target) answer++;
                rt++;
            } else {
                sum -= arr[lt++];
                sum -= arr[rt];
            }
        }
        System.out.println(answer);
    }

    private static int[] getPrimeNums(int N) {
        List<Integer> list = new ArrayList<>();
        for (int i = 2; i <= N; i++) {
            boolean flag = true;

            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    flag = false;
                    break;
                }
            }

            if (flag) list.add(i);
        }

        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) arr[i] = list.get(i);
        return arr;
    }
}