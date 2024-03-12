import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int N = Integer.parseInt(br.readLine());

        Deque<String> leftCursor = new ArrayDeque<>();
        Deque<String> rightCursor = new ArrayDeque<>();
        for (int i = 0; i < str.length(); i++) {
            leftCursor.push(String.valueOf(str.charAt(i)));
        }

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            if (command.equals("L")) {
                if (!leftCursor.isEmpty()) {
                    rightCursor.push(leftCursor.pop());
                }
            } else if (command.equals("D")) {
                if (!rightCursor.isEmpty()) {
                    leftCursor.push(rightCursor.pop());
                }
            } else if (command.equals("B")) {
                if (!leftCursor.isEmpty()) {
                    leftCursor.pop();
                }
            } else {
                String word = st.nextToken();
                leftCursor.push(word);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!rightCursor.isEmpty()) {
            leftCursor.push(rightCursor.pop());
        }

        for (String x : leftCursor) sb.append(x);
        sb.reverse();
        System.out.println(sb);
    }
}