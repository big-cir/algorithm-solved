import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<Integer, Long> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            int key = Integer.parseInt(str, 2);
            map.put(key, map.getOrDefault(key, 0L) + 1L);
        }

        
        long answer = 0;
        for (long value : map.values()) {
            if (value > 1) {
                answer += (value * (value - 1)) / 2;
            }
        }

        List<Integer> keys = new ArrayList<>(map.keySet());
        for (int i = 0; i < keys.size() - 1; i++) {
            int key1 = keys.get(i);

            for (int j = i + 1; j < keys.size(); j++) {
                int key2 = keys.get(j);
                if (Integer.bitCount(key1 ^ key2) <= 2) answer += map.get(key1) * map.get(key2);
            }
        }
        

        System.out.println(answer);
    }
}
