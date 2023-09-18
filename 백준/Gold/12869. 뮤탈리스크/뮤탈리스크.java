
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static final int[] damage = {1, 3, 9};
    static int answer;
    static int[] SCV;
    static boolean[][][] ch = new boolean[61][61][61];

    public static boolean toZero(int digit) {
        if (digit < 0) return false;
        return true;
    }

    public static void dfs(int pos1, int pos2, int pos3, int count) {
        if (!toZero(pos1)) pos1 = 0;
        if (!toZero(pos2)) pos2 = 0;
        if (!toZero(pos3)) pos3 = 0;

        if (pos1 == 0 && pos2 == 0 && pos3 == 0) {
            answer = Math.min(answer, count);
            return;
        }

        if (ch[pos1][pos2][pos3]) {
            return;
        } else {
            ch[pos1][pos2][pos3] = true;
        }

        if (answer < count) return;

        // 최대값 갱신
        int[] arr = {pos1, pos2, pos3};
        Arrays.sort(arr);
        pos1 = arr[2];
        pos2 = arr[1];
        pos3 = arr[0];

        // 6가지 경우의 수
        dfs(pos1 - damage[2], pos2 - damage[1], pos3 - damage[0], count + 1);
        dfs(pos1 - damage[2], pos2 - damage[0], pos3 - damage[1], count + 1);
        dfs(pos1 - damage[1], pos2 - damage[2], pos3 - damage[0], count + 1);
        dfs(pos1 - damage[1], pos2 - damage[0], pos3 - damage[0], count + 1);
        dfs(pos1 - damage[0], pos2 - damage[2], pos3 - damage[1], count + 1);
        dfs(pos1 - damage[0], pos2 - damage[1], pos3 - damage[2], count + 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        SCV = new int[3];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            SCV[i] = Integer.parseInt(st.nextToken());
        }

        answer = Integer.MAX_VALUE;
        dfs(SCV[0], SCV[1], SCV[2], 0);
        System.out.println(answer);
    }
}
