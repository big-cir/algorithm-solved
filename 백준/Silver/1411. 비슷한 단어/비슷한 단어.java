import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] strs = new String[N];
        String[] result = new String[N];
        StringBuilder sb = new StringBuilder();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            strs[i] = br.readLine();
            int value = 1;

            for (char x : strs[i].toCharArray()) {
                if (map.containsKey(x)) sb.append(map.get(x));
                else {
                    map.put(x, value);
                    sb.append(value++);
                }
            }

            result[i] = sb.toString();
            map.clear();
            sb.setLength(0);
        }
        
        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (result[i].equals(result[j])) answer++;
            }
        }

        System.out.println(answer);
    }
}
