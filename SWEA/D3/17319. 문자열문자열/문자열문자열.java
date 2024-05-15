import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tc; i++) {
            int length = Integer.parseInt(br.readLine());
            String after = br.readLine();

            if (length % 2 == 1) {
                addAnswer(sb, false, i);
				continue;
            }

            int size = length / 2;
            if (after.substring(0, size).equals(after.substring(size, length))) {
                addAnswer(sb, true, i);
            } else {
                addAnswer(sb, false, i);
            }
        }
        System.out.println(sb.deleteCharAt(sb.length() - 1));
    }

    private static void addAnswer(StringBuilder sb, boolean flag, int i) {
        sb.append("#" + (i + 1));
        if (!flag) {
            sb.append(" No");
        } else {
            sb.append(" Yes");
        }
        sb.append("\n");
    }
}
