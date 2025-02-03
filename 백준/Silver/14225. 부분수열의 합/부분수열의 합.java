import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static Set<Integer> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        combi(0, N, arr, 0);

        int val = 1;
        while (true) {
            if (set.contains(val)) {
                val++;
            } else {
                break;
            }
        }
        
        System.out.println(val);
    }

    private static void combi(int start, int N, int[] arr, int sum) {
        if (start == N) {
            set.add(sum);
            return;
        }

        combi(start + 1, N, arr, sum + arr[start]);
        combi(start + 1, N, arr, sum);
    }
}
