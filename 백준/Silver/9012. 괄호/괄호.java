import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            stack.clear();
            String answer = "YES";
            char[] chars = br.readLine().toCharArray();

            for (char x : chars) {
                if (x == '(') {
                    stack.push(x);
                } else {
                    if (stack.isEmpty()) {
                        answer = "NO";
                    } else {
                        stack.pop();
                    }
                }
            }

            if (!stack.isEmpty()) {
                answer = "NO";
            }

            System.out.println(answer);
        }
    }
}
