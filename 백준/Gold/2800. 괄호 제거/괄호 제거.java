import java.util.*;
import java.io.*;

public class Main {

    static List<Pos> list;
    static TreeSet<String> answer;

    static class Pos {
        int start;
        int end;

        public Pos(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        list = new ArrayList<>();

        Stack<Integer> stack = new Stack<>();
        char[] charArr = str.toCharArray();
        for (int i = 0; i < charArr.length; i++) {
            if (charArr[i] == '(') {
                stack.push(i);
            } else if (charArr[i] == ')') {
                Pos pos = new Pos(stack.pop(), i);
                list.add(pos);
            }
        }

        answer = new TreeSet<>();
        dfs(0, str, str);
        for (String result : answer) {
            System.out.println(result);
        }
    }

    private static void dfs(int level, String result, String origin) {
        if (level == list.size()) {
            result = result.replaceAll("\n", "");
            if (result.equals(origin)) return;

            answer.add(result);
            return;
        }

        Pos pos = list.get(level);
        StringBuilder sb = new StringBuilder(result);
        sb.setCharAt(pos.start, '\n');
        sb.setCharAt(pos.end, '\n');

        dfs(level + 1, sb.toString(), origin);
        dfs(level + 1, result, origin);
    }

}