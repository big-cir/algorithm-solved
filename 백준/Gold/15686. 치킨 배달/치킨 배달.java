import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M, answer;
    static int[][] map;
    static List<int[]> houses, chicken;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = info[0];
        M = info[1];

        map = new int[N][N];
        houses = new ArrayList<>();
        chicken = new ArrayList<>();
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) houses.add(new int[] {i, j});
                if (map[i][j] == 2) chicken.add(new int[] {i, j});
            }
        }

        answer = Integer.MAX_VALUE;
        int[] ch = new int[chicken.size()];
        backtrack(0, 0, ch);
        System.out.println(answer);
    }

    private static void backtrack(int level, int start, int[] ch) {
        if (level == M) {
            int sum = 0;
            for (int[] house : houses) {
                int minDis = Integer.MAX_VALUE;
                for (int i = 0; i < chicken.size(); i++) {
                    if (ch[i] == 1) {
                        minDis = Math.min(minDis, calDis(house, chicken.get(i)));
                    }
                }
                sum += minDis;
            }
            answer = Math.min(answer, sum);
            return;
        }

        for (int i = start; i < chicken.size(); i++) {
            if (ch[i] == 0) {
                ch[i] = 1;
                backtrack(level + 1, i, ch);
                ch[i] = 0;
            }
        }
    }

    private static int calDis(int[] house, int[] chickenPos) {
        return (Math.abs(house[0] - chickenPos[0]) + Math.abs(house[1] - chickenPos[1]));
    }
}
