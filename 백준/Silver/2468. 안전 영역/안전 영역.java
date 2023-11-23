import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int N, maxH;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        maxH = 0;
        for (int i = 0; i < N; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            maxH = Math.max(maxH, Arrays.stream(map[i]).max().getAsInt());
        }

        int answer = 0;
        for (int i = 0; i <= maxH; i++) {
            int[][] copy = new int[N][N];
            for (int j = 0; j < N; j++) copy[j] = map[j].clone();
            int[][] ch = new int[N][N];

            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (ch[j][k] == 0 && copy[j][k] <= i) {
                        ch[j][k] = 1;
                        copy[j][k] = -1;
                        painted(j, k, i, copy, ch);
                    }
                }
            }

            int max = 0;
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (ch[j][k] == 0 && copy[j][k] != -1) {
                        max++;
                        ch[j][k] = 1;
                        copy[j][k] = -1;
                        painted(j, k, maxH, copy, ch);
                    }
                }
            }
            answer = Math.max(answer, max);
        }
        System.out.println(answer);
    }

    private static void painted(int x, int y, int rainH, int[][] copy, int[][] ch) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < N && ny >= 0 && ny < N && ch[nx][ny] == 0) {
                if (copy[nx][ny] <= rainH) {
                    ch[nx][ny] = 1;
                    copy[nx][ny] = -1;
                    painted(nx, ny, rainH, copy, ch);
                }
            }
        }
    }
}
