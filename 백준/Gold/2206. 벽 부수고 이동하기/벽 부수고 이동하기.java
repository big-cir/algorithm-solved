import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M, answer = 0;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] map;
    static int[][][] ch;

    public static void bfs(int x, int y) {
        Queue<List<Integer>> queue = new LinkedList();
        List<Integer> list = List.of(0, 0, 0, 1);
        queue.offer(list);
        ch[x][y][0] = 1;

        while (!queue.isEmpty()) {
            List<Integer> tmp = queue.poll();
            if (tmp.get(0) + 1 == N && tmp.get(1) + 1 == M) {
                answer = tmp.get(3);
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nx = tmp.get(0) + dx[i];
                int ny = tmp.get(1) + dy[i];

                // 방문하지 않았고,
                if (nx >= 0 && nx < N && ny >= 0 && ny < M && ch[nx][ny][tmp.get(2)] == 0) {
                    if (map[nx][ny] == 0) {
                        ch[nx][ny][tmp.get(2)] = 1;
                        queue.offer(List.of(nx, ny, tmp.get(2), tmp.get(3) + 1));
                    }
                    // 벽을 깬적이 없을 떄
                    if (map[nx][ny] == 1 && tmp.get(2) == 0) {
                        ch[nx][ny][1] = 1;
                        queue.offer(List.of(nx, ny, 1, tmp.get(3) + 1));
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        ch = new int[N][M][2];

        for (int i = 0; i < N; i++) {
            map[i] = Arrays.stream(br.readLine().split("")).mapToInt(Integer::valueOf).toArray();
        }

        bfs(0, 0);
        System.out.println(answer == 0 ? "-1" : answer);
    }
}
