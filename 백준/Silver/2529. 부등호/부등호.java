import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] ch;
    static String[] opers;
    static List<String> results;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        opers = Arrays.stream(br.readLine().split(" ")).toArray(String[]::new);
        results = new ArrayList<>();
        ch = new int[10];

        recur(0, 0, -1, "");
        System.out.println(results.get(results.size() - 1));
        System.out.println(results.get(0));
    }

    private static void recur(int depth, int left, int operIdx, String result) {
        if (depth == N + 1) {
            results.add(result);
            return;
        }

        for (int i = 0; i <= 9; i++) {
            if (ch[i] == 0) {
                ch[i] = 1;
                if (depth == 0) {
                    recur(depth + 1, i, operIdx + 1, result + i);
                } else {
                    if (opers[operIdx].equals(">")) {
                        if (left > i) recur(depth + 1, i, operIdx + 1, result + i);
                    } else {
                        if (i > left) recur(depth + 1, i, operIdx + 1, result + i);
                    }
                }
                ch[i] = 0;
            }
        }
    }
}
