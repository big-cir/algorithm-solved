import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());

        String answer = "";
        if (a + b + c == 180) {
            if (a == 60 && a == b) answer = "Equilateral";
            else if (a == b || b == c || a == c) answer = "Isosceles";
            else if (a != b && b != c && c != a) answer = "Scalene";
        } else {
            answer = "Error";
        }
        System.out.println(answer);
    }
}
