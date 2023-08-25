import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    static int R, C, answer = 1;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static char[][] map;
    static Set<Character> set = new HashSet<>();

    public static void dfs(int x, int y, int count) {
        answer = Math.max(count, answer);

        for (var i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < R && ny >= 0 && ny < C ) {
                if (set.contains(map[nx][ny])) continue;
                set.add(map[nx][ny]);
                dfs(nx, ny, count + 1);
                set.remove(map[nx][ny]);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];

        for (var i = 0; i < R; i++) {
            map[i] = br.readLine().toCharArray();
        }

        set.add(map[0][0]);
        dfs(0, 0, 1);
        System.out.println(answer);
    }
}
