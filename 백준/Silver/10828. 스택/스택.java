import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] command = new String[N];

        for (int i = 0; i < N; i++) {
            command[i] = br.readLine();
        }

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            String str = command[i];
            if (str.length() >= 6) {
                stack.push(Integer.valueOf(str.substring(5, str.length())));
            } else if (str.equals("pop")) {
                if (stack.isEmpty()) {
                    System.out.println("-1");
                } else {
                    System.out.println(stack.pop());
                }
            } else if (str.equals("size")) {
                System.out.println(stack.size());
            } else if (str.equals("empty")) {
                if (stack.isEmpty()) {
                    System.out.println("1");
                } else {
                    System.out.println("0");
                }
            } else {
                if (stack.isEmpty()) {
                    System.out.println("-1");
                } else {
                    System.out.println(stack.peek());
                }
            }
        }
    }
}
