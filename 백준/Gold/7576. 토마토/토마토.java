import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, anwer = 0;
    static int[][] graph, ch;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static Queue<Point> queue = new LinkedList<>();

    public static class Point {
        private int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void BFS() {
        while (!queue.isEmpty()) {
            Point cur = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx >= 0 && nx < M && ny >= 0 && ny < N && ch[nx][ny] == 0 && graph[nx][ny] == 0) {
                    queue.offer(new Point(nx, ny));
                    ch[nx][ny] = ch[cur.x][cur.y] + 1;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        ch = new int[M][N];
        graph = new int[M][N];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int val = Integer.parseInt(st.nextToken());
                graph[i][j] = val;

                if (val == 1) {
                    queue.offer(new Point(i, j));
                    ch[i][j] = 1;
                }

                if (val == -1) {
                    ch[i][j] = -1;
                }
            }
        }

        BFS();

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                anwer = Math.max(ch[i][j], anwer);
                list.add(ch[i][j]);
                if (ch[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
            }
        }

        if (list.contains(0)) {
            System.out.println(0);
        } else {
            System.out.println(anwer - 1);
        }
    }
}