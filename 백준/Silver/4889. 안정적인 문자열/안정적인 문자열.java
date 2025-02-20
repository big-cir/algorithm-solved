import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = 1;
         String input;
        while (true) {
            input = br.readLine();
            if (input.contains("-")) break;
            
            int answer = 0;
            Stack<Character> ls = new Stack<>();
            Stack<Character> rs = new Stack<>();
            char[] chars = input.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                char ch = chars[i];

                if (ch == '}') {
                    if (ls.isEmpty()) rs.push(ch);
                    else {
                        ls.pop();
                    }
                } else {
                    ls.push(ch);
                }
            }

            if (!ls.isEmpty()) {
                answer += ls.size() / 2;
            }

            if (!rs.isEmpty()) {
                answer += rs.size() / 2;
            }

            answer += (ls.size() % 2 + rs.size() % 2);
            System.out.println(tc++ + ". " + answer);
        }
    }
}
