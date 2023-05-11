import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int L = Integer.parseInt(st.nextToken());
            int U = Integer.parseInt(st.nextToken());
            int X = Integer.parseInt(st.nextToken());

            System.out.print("#" + i + " ");
            if (X > U) {
                System.out.print(-1);
            } else if (X > L) {
                System.out.print(0);
            } else {
                System.out.print(L - X);
            }
            System.out.println();
        }
    }
}
