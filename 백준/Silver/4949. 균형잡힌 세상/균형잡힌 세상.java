import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while (!(str = br.readLine()).equals(".")) {
            Deque<Character> stack = new ArrayDeque<>();
            boolean flag = true;
            for (char x : str.toCharArray()) {
                if (x == '[' || x == '(') stack.push(x);
                else {
                    if (x == ']') {
                        if (stack.isEmpty() || stack.peek() != '[') {
                            flag = false;
                            System.out.println("no");
                            break;
                        } else stack.pop();
                    }

                    if (x == ')') {
                        if (stack.isEmpty() || stack.peek() != '(') {
                            flag = false;
                            System.out.println("no");
                            break;
                        } else stack.pop();
                    }
                }
            }
            if (!flag) continue;
            if (stack.isEmpty()) System.out.println("yes");
            else System.out.println("no");
        }
    }
}
