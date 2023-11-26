import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long max = Long.MIN_VALUE;
        long minK = Long.MAX_VALUE;
        Map<Long, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            long val = Long.parseLong(br.readLine());
            map.put(val, map.getOrDefault(val, 0) + 1);
            if (max < map.get(val) || (max == map.get(val) && val < minK)) {
                max = map.get(val);
                minK = val;
            }
        }
        System.out.println(minK);
    }
}
