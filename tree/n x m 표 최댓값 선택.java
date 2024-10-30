import java.io.*;
import java.util.*;

public class Main {

    static int n, m, answer;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = info[0];
        m = info[1];
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        answer = Integer.MIN_VALUE;
        backtrack(new ArrayList<>(), 0);
        System.out.println(answer);
    }

    private static void backtrack(List<Integer> list, int idx) {
        if (list.size() == 3) {
            int sum = 0;
            for (int row = 0; row < n; row++) {
                int max = 0;
                for (int col = 0; col < m; col++) {
                    if (list.contains(col)) continue;
                    max = Math.max(max, map[row][col]);
                }
                sum += max;
            }

            answer = Math.max(answer, sum);
            return;
        }

        for (int i = idx; i < m; i++) {
            list.add(i);
            backtrack(list, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
