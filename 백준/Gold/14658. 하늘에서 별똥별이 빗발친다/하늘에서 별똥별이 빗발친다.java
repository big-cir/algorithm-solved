import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M, L, K;
    static List<int[]> stars;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        stars = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            stars.add(new int[] {x, y});
        }

        int max = 0;
        for (int[] star : stars) {
            int fixX = star[0];

            for (int[] star2 : stars) {
                int fixY = star2[1];
                int nFixX = fixX + L;
                int nFixY = fixY + L;
                int cnt = 0;

                for (int[] comp : stars) {
                    if (comp[0] >= fixX && comp[0] <= nFixX && comp[1] >= fixY && comp[1] <= nFixY) {
                        cnt++;
                    }

                    max = Math.max(max, cnt);
                }
            }
        }

        System.out.println(K - max);
    }
}