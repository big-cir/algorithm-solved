import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> val = new Stack<>();
        Stack<Integer> pos = new Stack<>();
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(st.nextToken());
            if (val.isEmpty()) {
                sb.append(0).append(" ");
                val.push(input);
                pos.push(i + 1);
            } else {
                while (true) {
                    if (val.isEmpty()) {
                        sb.append(0).append(" ");
                        val.push(input);
                        pos.push(i + 1);
                        break;
                    }

                    if (val.peek() > input) {
                        sb.append(pos.peek()).append(" ");
                        val.push(input);
                        pos.push(i + 1);
                        break;
                    } else {
                        val.pop();
                        pos.pop();
                    }
                }
            }
        }
        System.out.println(sb);
    }
}
