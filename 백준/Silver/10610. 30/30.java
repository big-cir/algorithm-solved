import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();

        int sum = 0;
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        for (char x : arr) {
            sum += x - '0';
            sb.append(x);
        }

        if (sum % 3 != 0 || sb.charAt(0) != '0') {
            System.out.println(-1);
            return;
        }

        System.out.println(sb.reverse());
    }
}
