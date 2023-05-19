import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            List<Integer> list = new ArrayList<>();

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                list.add(Integer.parseInt(st.nextToken()));
            }

            int answer = 0;
            for (int i = 0; i < K; i++) {
                int max = list.stream().mapToInt(Integer::intValue).max().getAsInt();
                answer += max;
                list.remove(Integer.valueOf(max));
            }

            System.out.println("#" + tc + " " + answer);
        }
    }
}