import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Integer>[] list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) list[i] = new ArrayList<>();
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int point = Integer.parseInt(st.nextToken());
            int color = Integer.parseInt(st.nextToken());
            list[color].add(point);
        }

        int answer = 0;
        for (int i = 1; i <= N; i++) {
            List<Integer> now = list[i];
            Collections.sort(now);

            if (now.size() >= 2) {
                for (int j = 0; j < now.size(); j++) {
                    if (j == 0) answer += now.get(j + 1) - now.get(j);
                    else if (j == now.size() - 1) answer += now.get(j) - now.get(j - 1);
                    else {
                        answer += Math.min(now.get(j) - now.get(j - 1), now.get(j + 1) - now.get(j));
                    }
                }
            }
        }
        System.out.println(answer);
    }
}