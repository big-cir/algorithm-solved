import java.util.*;
import java.io.*;

public class Main {

    static int N, answer;
    static int[] ch;
    static List<int[]> pos;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        pos = new ArrayList<>();

        pos.add(new int[] {0, 0});
        for (int i = 0; i < N; i++) {
            int[] info = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            pos.add(info);
        }

        answer = 0;
        ch = new int[N + 1];
        backtrack(0, new int[] {0, 0}, -1);

        System.out.println(answer);
    }

    private static void backtrack(int level, int[] start, int dir) {
        if (level == N + 1) {
            if (start[0] == 0 && start[1] == 0) answer++;
            return;
        }

        for (int i = 0; i < N + 1; i++) {
            int[] next = pos.get(i);

            if (start[0] == next[0] && start[1] == next[1]) continue;

            int curDir = -1;
            if (start[0] == next[0] && start[1] < next[1]) curDir = 0;
            else if (start[0] < next[0] && start[1] == next[1]) curDir = 1;
            else if (start[0] == next[0] && start[1] > next[1]) curDir = 2;
            else if (start[0] > next[0] && start[1] == next[1]) curDir = 3;

            if (dir == curDir) continue;
            if (start[0] == next[0] || start[1] == next[1]) {
                if (ch[i] == 0) {
                    ch[i] = 1;
                    backtrack(level + 1, next, curDir);
                    ch[i] = 0;
                }
            }
        }
    }
}
