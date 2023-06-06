import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input = br.readLine().toCharArray();

        Stack<Character> stack = new Stack<>();
        int answer = 0;

        int tmp = 1;
        for (int i = 0; i < input.length; i++) {
            if (input[i] == '(') {
                stack.push(input[i]);
                tmp *= 2;
            } else if (input[i] == '[') {
                stack.push(input[i]);
                tmp *= 3;
            } else {
                if (input[i] == ')') {
                    if (stack.isEmpty() || stack.peek() != '(') {
                        answer = 0;
                        break;
                    } else if (input[i - 1] == '(') {
                        answer += tmp;
                    }
                    stack.pop();
                    tmp /= 2;
                }

                if (input[i] == ']') {
                    if (stack.isEmpty() || stack.peek() != '[') {
                        answer = 0;
                        break;
                    } else if (input[i - 1] == '[') {
                        answer += tmp;
                    }
                    stack.pop();
                    tmp /= 3;
                }
            }
        }

        if (!stack.isEmpty()) answer = 0;
        System.out.println(answer);
    }
}
