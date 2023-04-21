import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    private static int[] money = {50000, 10000, 5000, 1000, 500, 100, 50, 10};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            int N = Integer.parseInt(br.readLine());
            int[] answer = new int[money.length];
            StringBuilder sb = new StringBuilder();

            for (int j = 0; j < money.length; j++) {
                int sh = N / money[j];
                N -= sh * money[j];
                answer[j] = sh;
            }

            System.out.println(sb.append("#").append(i + "\n").append(answer[0] + " ")
                    .append(answer[1] + " ").append(answer[2] + " ")
                    .append(answer[3] + " ").append(answer[4] + " ")
                    .append(answer[5] + " ").append(answer[6] + " ")
                    .append(answer[7]));
        }
    }
}
