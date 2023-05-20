import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int max;
    static int[] box;
    public static boolean check(int number) {
        String str = Integer.toString(number);
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) - '0' > str.charAt(i + 1) - '0') return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            sb.setLength(0);
            int N = Integer.parseInt(br.readLine());
            box = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                box[i] = Integer.parseInt(st.nextToken());
            }

            max = -1;
            for (int i = 0; i < N; i++) {
                for (int j = i + 1; j < N; j++) {
                    int sum = box[i] * box[j];
                    if (check(sum)) {
                        max = Math.max(sum, max);
                    }
                }
            }

            sb.append("#").append(tc).append(" ").append(max);
            System.out.println(sb);
        }
    }
}