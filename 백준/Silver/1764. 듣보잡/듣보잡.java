import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M;
    static String[] heard;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        setSolution(br);
    }

    private static void setSolution(BufferedReader br) throws IOException {
        Set<String> set = new HashSet<>();
        List<String> answer = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            set.add(br.readLine());
        }

        for (int i = 0; i < M; i++) {
            String str = br.readLine();
            if (!set.add(str)) {
                answer.add(str);
            }
        }
        Collections.sort(answer);
        System.out.println(answer.size());
        for (String x : answer) {
            System.out.println(x);
        }
    }
}
