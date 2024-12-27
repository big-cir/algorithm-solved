import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] nums, arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[1000001];
        Arrays.fill(arr, Integer.MIN_VALUE);

        nums = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int val = Integer.parseInt(st.nextToken());
            nums[i] = val;
            arr[val] = 0;
        }

        int max = Arrays.stream(nums).max().getAsInt();

        for (int i = 0; i < N; i++) {
            int val = nums[i];

            for (int j = val * 2; j <= max; j += val) {
                if (arr[j] != Integer.MIN_VALUE) {
                    arr[val]++;
                    arr[j]--;
                }
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < N; i++) {
            result.append(arr[nums[i]]).append(" ");
        }
        System.out.println(result);
    }
}