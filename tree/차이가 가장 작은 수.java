import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(br.readLine());
            set.add(value);
            arr[i] = value;
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            int value = arr[i];

            if (set.ceiling(M + value) != null) {
                min = Math.min(min, set.ceiling(M + value) - value);
            } else if (set.floor(value - M) != null) {
                min = Math.min(min, value - set.floor(value - M));
            }
        }

        if (min == Integer.MAX_VALUE) min = -1;
        System.out.println(min);
    }
}
