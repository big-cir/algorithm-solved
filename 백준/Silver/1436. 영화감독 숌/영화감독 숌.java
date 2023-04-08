import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int current = 0;

        while (N > 0) {
            current++;
            if (String.valueOf(current).contains("666")) {
                N--;
            }
        }

        System.out.println(current);
    }
}