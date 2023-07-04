import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<Character> stack = new Stack<>();
        String answer;
        for (int i = 0; i < N; i++) {
            answer = "YES";
            char[] inputs = br.readLine().toCharArray();

            for (char x : inputs) {
                if (x == '(') stack.push(x);
                else {
                    if (stack.isEmpty()) {
                        answer = "NO";
                        break;
                    } else {
                        stack.pop();
                    }
                }
            }
            if (!stack.isEmpty()) answer = "NO";

            stack.clear();
            System.out.println(answer);
        }
    }
}
