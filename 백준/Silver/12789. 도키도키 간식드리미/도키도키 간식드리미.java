import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int num = 1;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            int value = arr[i];
            if (value == num) {
                num++;
            } else if (!stack.isEmpty() && stack.peek() == num) {
                stack.pop();
                num++;
                i--;
            } else {
                stack.push(value);
            }
        }

        while (!stack.isEmpty()) {
            if (stack.pop() != num) {
                System.out.println("Sad");
                return;
            } else {
                num++;
            }
        }

        System.out.println("Nice");
    }
}