import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        for (int i = 0; i < tc; i++) {
            int n = Integer.parseInt(br.readLine());
            Map<String, Integer> map = new HashMap<>();

            StringTokenizer st;
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                String name = st.nextToken();
                String wear = st.nextToken();
                map.put(wear, map.getOrDefault(wear, 0) + 1);
            }

            int answer = 1;
            for (String key : map.keySet()) {
                answer *= ((map.get(key) + 1));
            }
            System.out.println(answer - 1);
        }
    }
}
