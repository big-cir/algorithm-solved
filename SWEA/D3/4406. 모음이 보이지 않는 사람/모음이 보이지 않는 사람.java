import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            String input = br.readLine();
            input = input.replaceAll("a|e|i|o|u", "");
            System.out.println("#" + tc + " " + input);
        }
    }
}
