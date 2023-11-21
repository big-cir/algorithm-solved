import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();

        int value = 1;
        Map<String, Integer> dict = new HashMap<>();
        Map<Integer, String> reverseIdx = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            dict.put(input, value++);
        }

        for (Map.Entry<String, Integer> entry : dict.entrySet()) {
            reverseIdx.put(entry.getValue(), entry.getKey());
        }

        for (int i = 0; i < M; i++) {
            String input = br.readLine();
            if (input.matches("^[0-9]*$")) {
                sb.append(reverseIdx.get(Integer.parseInt(input)) + "\n");
            } else {
                sb.append(dict.get(input) + "\n");
            }
        }
        System.out.println(sb);
    }
}
