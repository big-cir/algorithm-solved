import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String[] file = br.readLine().split("\\.");
            map.put(file[1], map.getOrDefault(file[1], 0) + 1);
        }

        String[] sortedKeys = map.keySet().stream().sorted().toArray(String[]::new);
        for (String key : sortedKeys) {
            System.out.println(key + " " + map.get(key));
        }
    }
}
