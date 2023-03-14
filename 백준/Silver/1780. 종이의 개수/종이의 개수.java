import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static boolean identical(int x, int y, int[][] map, int arrSize) {
        int val = map[x][y];

        for (int i = x; i < x + arrSize; i++) {
            for (int j = y; j < y + arrSize; j++) {
                if (map[i][j] != val) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void solution(int x, int y, int[][] map, int arrSize, int[] answer) {
        if (identical(x, y, map, arrSize)) {
            answer[map[x][y]] += 1;
        } else {
            arrSize /= 3;

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    solution(x + arrSize * i, y + arrSize * j, map, arrSize, answer);
                }
            }

        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] map = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int input = Integer.parseInt(st.nextToken());
                if (input == - 1) {
                    input = 2;
                }
                map[i][j] = input;
            }
        }

        int[] answer = new int[3];
        solution(0, 0, map, N, answer);
        System.out.println(answer[2]);
        System.out.println(answer[0]);
        System.out.println(answer[1]);
    }
}
