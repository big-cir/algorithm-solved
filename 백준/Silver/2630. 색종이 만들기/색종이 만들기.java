import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] answer;

    public static boolean identical(int x, int y, int size, int[][] map) {
        int val = map[x][y];

        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (val != map[i][j]) return false;
            }
        }
        return true;
    }

    public static void solution(int x, int y, int size, int[][] map) {
        if (identical(x, y, size, map)) {
            answer[map[x][y]] += 1;
        } else {
            size /= 2;

            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    solution(x + size * i, y + size * j, size, map);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        answer = new int[2];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solution(0, 0, N, map);
        System.out.println(answer[0]);
        System.out.println(answer[1]);
    }
}
