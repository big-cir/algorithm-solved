import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M, answer;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static char[][] map;
    static int[][] ch;

    public static void dfs(int x, int y) {
        ch[x][y] = 1;
        if (map[x][y] == 'P') {
            answer++;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < N && ny >= 0 && ny < M && ch[nx][ny] == 0) {
                dfs(nx, ny);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        ch = new int[N][M];

        // O + 공간, X : 벽, I 도연, P 사람
        int xI = 0;
        int yI = 0;
        for (int i = 0; i < N; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                if (input[j] == 'I') {
                    xI = i;
                    yI = j;
                    ch[i][j] = 1;
                }

                if (input[j] == 'X') {
                    ch[i][j] = 1;
                }

                map[i][j] = input[j];
            }
        }

        answer = 0;
        dfs(xI, yI);
        System.out.println(answer == 0 ? "TT" : answer);
    }
}
