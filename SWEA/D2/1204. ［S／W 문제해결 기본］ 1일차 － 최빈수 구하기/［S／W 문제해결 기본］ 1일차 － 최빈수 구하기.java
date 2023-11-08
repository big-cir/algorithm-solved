import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    static final String SHOP = "#";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        for (int i = 0; i < tc; i++) {
            int tcNumber = Integer.parseInt(br.readLine());
            int answer = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            Map<Integer, Integer> map = new HashMap<>();
            while (st.hasMoreTokens()) {
                int value = Integer.parseInt(st.nextToken());
                map.put(value, map.getOrDefault(value, 0) + 1);
            }

            int max = Integer.MIN_VALUE;
            Object[] keyArray = map.keySet().toArray();
            Arrays.sort(keyArray);

            for (int key : map.keySet()) {
                if (map.get(key) >= max) {
                    max = map.get(key);
                    answer = key;
                }
            }

            System.out.println(SHOP + tcNumber + " " + answer);
        }
    }
}
