import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringBuilder sb = new StringBuilder();
        ArrayDeque<Character> stack = new ArrayDeque<>();

        // A*(B+C) -> ABC+*
        // AB       *(
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch >= 'A') sb.append(ch);
            else if (ch == '(') stack.push(ch);
            else if (ch == ')') {
                while (!stack.isEmpty()) {
                    char top = stack.pop();
                    if (top != '(') sb.append(top);
                    else break;
                }
            } else {
                //  AB
                //  stack : +
                // 연산자 우선순위 크면 push
                while (!stack.isEmpty()) {
                    char oper = stack.peek();
                    if (oper == '(') break;
                    if (gap(oper) < gap(ch) || oper == '(') break;
                    else sb.append(stack.pop());
                }
                stack.push(ch);
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        System.out.println(sb);
    }

    private static int gap(char ch) {
        if (ch == '*' || ch == '/') return 1;
        return 0;
    }
}
