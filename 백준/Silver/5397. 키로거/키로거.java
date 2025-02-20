import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringBuilder sb = new StringBuilder();
            char[] chars = br.readLine().toCharArray();

            Stack<Character> ls = new Stack<>();
            Stack<Character> rs = new Stack<>();
            for (int j = 0; j < chars.length; j++) {
                char cur = chars[j];

                if (cur == '<') {
                    if (!ls.isEmpty()) {
                        rs.push(ls.pop());
                    }
                } else if (cur == '>') {
                    if (!rs.isEmpty()) {
                        ls.push(rs.pop());
                    }
                } else if (cur == '-') {
                    if (!ls.isEmpty()) ls.pop();
                } else {
                    ls.push(cur);
                }
            }

            while (!ls.isEmpty()) {
                rs.push(ls.pop());
            }

            while (!rs.isEmpty()) {
                sb.append(rs.pop());
            }

            System.out.println(sb);
        }
    }
}
