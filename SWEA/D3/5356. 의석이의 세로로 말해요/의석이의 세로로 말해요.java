import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    static String[] str;
    static int max;

    public static String solution() {
        String answer = "";

        for (int i = 0; i < max; i++) {
            for (int j = 0; j < 5; j++) {
                if ((i + 1) > str[j].length()) continue;
                answer += str[j].substring(i, i + 1);
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            str = new String[5];
            max = 0;
            for (int i = 0; i < 5; i++) {
                str[i] = br.readLine();
                max = Math.max(max, str[i].length());
            }

            System.out.println("#" + tc + " " + solution());
        }
    }
}
