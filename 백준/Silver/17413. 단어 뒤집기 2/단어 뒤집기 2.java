import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Deque<Character> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch == '<') {
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                while (str.charAt(i) != '>') {
                    sb.append(str.charAt(i));
                    i++;
                }
                sb.append(">");
            } else if (ch == ' ') {
                while (str.charAt(i) != ' ') i++;
                while (!stack.isEmpty()) sb.append(stack.pop());
                sb.append(" ");
            } else {
                stack.push(ch);
            }
        }

        while (!stack.isEmpty()) sb.append(stack.pop());
        System.out.println(sb);
    }
}
