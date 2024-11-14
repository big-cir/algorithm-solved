import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static List<int[]> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        list = new ArrayList<>();
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            list.add(new int[] {v1, v2});
        }
        Collections.sort(list, ((o1, o2) -> o1[0] - o2[0]));

        int[] dp = new int[N];
        dp[0] = 1;
        for (int i = 1; i < N; i++) {
            dp[i] = 1;
            int[] fix = list.get(i);
            for (int j = i - 1; j >= 0; j--) {
                int[] comp = list.get(j);
                if (fix[1] > comp[1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        System.out.println(N - Arrays.stream(dp).max().getAsInt());
    }
}