import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int Q = Integer.parseInt(st.nextToken());
            int[] box = new int[N + 1];

            for (int i = 0; i < Q; i++) {
                st = new StringTokenizer(br.readLine());
                int L = Integer.parseInt(st.nextToken());
                int R = Integer.parseInt(st.nextToken());

                for (int j = L; j <= R; j++) {
                    box[j] = i + 1;
                }
            }

            System.out.print("#" + tc);
            for (int i = 1; i <= N; i++) {
                System.out.print(" " + box[i]);
            }
            System.out.println();
        }
    }
}
