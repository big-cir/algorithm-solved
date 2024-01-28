import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M, answer, cnt;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] map;
    static List<int[]> virusOccur;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        cnt = N * N;

        virusOccur = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] != 0) cnt--;
                if (map[i][j] == 2) virusOccur.add(new int[] {i, j});
            }
        }

        if (cnt == 0) {
            System.out.println(0);
        } else {
            answer = Integer.MAX_VALUE;
            backtrack(0, new int[virusOccur.size()], 0, new ArrayList<>());

            if (answer == Integer.MAX_VALUE) answer = -1;
            System.out.println(answer);
        }
    }

    private static void backtrack(int start, int[] ch, int count, List<int[]> virusPos) {
        if (count == M) {
            bfs(virusPos);
            return;
        }

        // 백트래킹 -> 활성 바이러스 지정
        for (int i = start; i < virusOccur.size(); i++) {
            if (ch[i] == 0) {
                ch[i] = 1;
                int[] vr = new int[] {virusOccur.get(i)[0], virusOccur.get(i)[1]};
                virusPos.add(vr);
                backtrack(i + 1, ch, count + 1, virusPos);
                virusPos.remove(vr);
                ch[i] = 0;
            }
        }
    }

    private static void bfs(List<int[]> virusPos) {
        int virus = 0;
        int[][] ch = new int[map.length][map[0].length];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < virusPos.size(); i++) {
            queue.offer(new int[] {virusPos.get(i)[0], virusPos.get(i)[1], 0});
            ch[virusPos.get(i)[0]][virusPos.get(i)[1]] = 1;
        }

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < N && (map[nx][ny] == 0 || map[nx][ny] == 2) && ch[nx][ny] == 0) {
                    if (map[nx][ny] == 0) {
                        ch[nx][ny] = 1;
                        virus++;
                        queue.offer(new int[] {nx, ny, now[2] + 1});
                    } else {
                        ch[nx][ny] = 1;
                        queue.offer(new int[] {nx, ny, now[2] + 1});
                    }

                    if (virus == cnt) {
                        answer = Math.min(answer, now[2] + 1);
                        return;
                    }
                }
            }
        }
    }
}
