import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        Set<String> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            set.add(br.readLine());
        }

        List<String> answer = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            String compare = br.readLine();
            if (set.contains(compare)) {
                answer.add(compare);
            }
        }

        Collections.sort(answer);
        System.out.println(answer.size());
        for (String x : answer) {
            System.out.println(x);
        }
    }
}
