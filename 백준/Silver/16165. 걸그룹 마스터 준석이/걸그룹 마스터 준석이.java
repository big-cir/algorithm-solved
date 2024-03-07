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

        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String team = br.readLine();
            int cnt = Integer.parseInt(br.readLine());

            List<String> members = new ArrayList<>();
            for (int j = 0; j < cnt; j++) {
                members.add(br.readLine());
            }
            map.put(team, members);
        }

        for (int i = 0; i < M; i++) {
            String input = br.readLine();
            int num = Integer.parseInt(br.readLine());

            if (num == 0) {
                List<String> members = map.get(input);
                Collections.sort(members);
                for (String answer : members) System.out.println(answer);
            } else {
                for (String key : map.keySet()) {
                    List<String> members = map.get(key);
                    if (members.contains(input)) {
                        System.out.println(key);
                        break;
                    }
                }
            }
        }
    }
}
