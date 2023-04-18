import java.io.*;
import java.util.*;

public class Solution {

    public static long getMaxPrice(List<Integer> list) {
        long result = 0;
        int max = Collections.max(list);

        for (int i = 0; i < list.size(); i++) {
            if (max == list.get(i)) {
                if (i + 1 == list.size()) continue;
                max = Collections.max(list.subList(i + 1, list.size()));
            } else {
                result += max - list.get(i);
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            List<Integer> price = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                price.add(Integer.parseInt(st.nextToken()));
            }
            System.out.println("#" + (i + 1) + " " + getMaxPrice(price));
        }
    }
}

