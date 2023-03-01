import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    static StringBuilder sb =  new StringBuilder();
    static int use_val = 0;
    static Stack<Integer> stack;
    static boolean flag = true;

    public static void solution(int x, Stack<Integer> stack) {
        for (int i = 1; i <= x; i++) {
            if (use_val >= i) continue;
            stack.push(++use_val);
            sb.append("+").append("\n");
        }

        if (stack.peek() == x) {
            stack.pop();
            sb.append("-").append("\n");
        } else if (stack.peek() != x) {
            flag = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

//        for (int i = 0; i < N; i++) {
//            A[i] = Integer.parseInt(br.readLine());
//        }

        stack = new Stack<>();
        while (N-- > 0) {
            solution(Integer.parseInt(br.readLine()), stack);
        }

        if (flag) {
            System.out.println(sb);
        } else {
            System.out.println("NO");
        }
    }
}
