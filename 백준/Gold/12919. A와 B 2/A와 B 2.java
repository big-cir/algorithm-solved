import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static String S, T;
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = br.readLine();
        T = br.readLine();

        answer = 0;
        recursive(T);
        System.out.println(answer);
    }

    private static void recursive(String str) {
        if (str.length() < S.length()) return;
        if (str.length() == S.length() && str.equals(S)) {
            answer = 1;
            return;
        }

        StringBuilder sb = new StringBuilder(str);
        if (str.endsWith("A")) {
            recursive(sb.substring(0, str.length() - 1));
        }

        if (str.startsWith("B")) {
            sb.reverse();
            recursive(sb.substring(0, str.length() - 1));
        }
    }
}
