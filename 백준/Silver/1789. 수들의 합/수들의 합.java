import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long S = Long.parseLong(br.readLine());

        int answer = 0;
        long sum = 0;
        for (int i = 1; i <= S; i++) {
            if (sum > S) break;
            sum += i;
            answer++;
        }
        if (S == 1) answer = 2;
        System.out.println(answer - 1);
    }
}