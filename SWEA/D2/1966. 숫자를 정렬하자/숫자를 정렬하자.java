import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] answer = new int[N];
            for (int j = 0; j < N; j++) {
                answer[j] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(answer);
            StringBuilder sb = new StringBuilder();
            sb.append("#" + i).append(" ");
            for (int j = 0; j < N; j++) {
                sb.append(answer[j] + " ");
            }

            System.out.println(sb);
        }
    }
}
