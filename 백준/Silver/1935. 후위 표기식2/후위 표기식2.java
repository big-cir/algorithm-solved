import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[] prefix = br.readLine().toCharArray();
        Stack<Double> value = new Stack<>();

        double[] num = new double[N];
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(br.readLine());
        }

        for (char x : prefix) {
            if (x >= 'A' && x <= 'Z') {
                value.push(num[x - 'A']);
            } else {
                if (x == '+') {
                    value.push(value.pop() + value.pop());
                } else if (x == '-') {
                    double tmp = value.pop();
                    value.push(value.pop() - tmp);
                } else if (x == '*') {
                    value.push(value.pop() * value.pop());
                } else {
                    double tmp = value.pop();
                    value.push(value.pop() / tmp);
                }
            }
        }
        System.out.println(String.format("%.2f", value.pop()));
    }
}
