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
            List<Integer> list = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            for (int i = 1; i <= N; i++) {
                list.add(i);
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < K; i++) {
                list.remove(Integer.valueOf(Integer.parseInt(st.nextToken())));
            }

            System.out.print("#" + tc + " ");
            for (int x : list) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
}
