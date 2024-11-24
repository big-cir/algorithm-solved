import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] chars = br.readLine().toCharArray();
        Deque<Character> stack = new ArrayDeque<>();

        for (char ch : chars) {
            if (ch == ')') {
                if (stack.isEmpty()) {
                    System.out.println("No");
                    return;
                }
                stack.pop();
            } else {
                stack.push('(');
            }
        }

        if (!stack.isEmpty()) {
            System.out.println("No");
        } else {
            System.out.println("Yes");
        } 
    }
}
