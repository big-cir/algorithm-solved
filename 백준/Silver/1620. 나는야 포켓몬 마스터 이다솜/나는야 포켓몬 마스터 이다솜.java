import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());       // 포켓몬 개수
        int M = Integer.parseInt(st.nextToken());       // 맞춰야하는 문제 개수

        Map<Integer, String> map = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            map.put(i + 1, str);
            map2.put(str, i + 1);
        }

        for (int i = 0; i < M; i++) {
            String input = br.readLine();
            if (input.matches("^[0-9]*$")) {
                int value = Integer.parseInt(input);
                System.out.println(map.get(value));
            } else {
                System.out.println(map2.get(input));
            }
        }
    }
}
