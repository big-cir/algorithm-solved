import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();

        char[] ch1 = str1.toCharArray();
        char[] ch2 = str2.toCharArray();
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        for (int i = 1; i <= ch1.length; i++) {
            char str1Ch = ch1[i - 1];
            for (int j = 1; j <= ch2.length; j++) {
                char str2Ch = ch2[j - 1];
                if (str1Ch == str2Ch) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        System.out.println(dp[str1.length()][str2.length()]);
    }
}
