import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int[] queen;
    public static int answer = 0;
    public static boolean flag = true;

    public static void dfs(int Level, int N) {
        if (Level == N) {
            answer++;
            return;
        } else {
            for (int i = 0; i < N; i++) {
                queen[Level] = i;

                flag = true;
                for (int j = 0; j < Level; j++) {
                    if (queen[j] == queen[Level]) {
                        flag = false;
                        break;
                    } else if (Math.abs(queen[Level] - queen[j]) == Math.abs(Level - j)) {
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    dfs(Level + 1, N);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        queen = new int[N];

        dfs(0, N);
        System.out.println(answer);
    }
}