import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, K;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] map, ch;

    public static class Corn implements Comparable<Corn> {
        private int x;
        private int y;
        private int val;

        public Corn(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }

        @Override
        public int compareTo(Corn o) {
            return o.val - val;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        ch = new int[N][M];

        PriorityQueue<Corn> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        K = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (i == 0 || i == N - 1 || j == 0 || j == M - 1) {
                    pq.add(new Corn(i, j, map[i][j]));
                    ch[i][j] = 1;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            Corn cur = pq.poll();
            sb.append((cur.x + 1) + " " + (cur.y + 1)).append("\n");

            K--;
            if (K == 0) {
                System.out.print(sb);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M && ch[nx][ny] == 0) {
                    ch[nx][ny] = 1;
                    pq.add(new Corn(nx, ny, map[nx][ny]));
                }
            }
        }
    }
}
