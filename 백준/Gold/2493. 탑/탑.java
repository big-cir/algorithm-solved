import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static class Top {
        private int position;
        private int h;

        public Top(int position, int h) {
            this.position = position;
            this.h = h;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] answer = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<Top> stack = new Stack<>();
        for (int i = 0; i < N; i++) {
            int height = Integer.parseInt(st.nextToken());
            Top top = new Top(i + 1, height);

            if (stack.isEmpty()) {
                answer[i] = 0;
                stack.push(top);
            } else {
                while (true) {
                    if (stack.isEmpty()) {
                        answer[i] = 0;
                        stack.push(top);
                        break;
                    }

                    if (stack.peek().h > top.h) {
                        answer[i] = stack.peek().position;
                        stack.push(top);
                        break;
                    } else {
                        stack.pop();
                    }
                }
            }
        }

        for (int x : answer) {
            System.out.print(x + " ");
        }
    }
}
