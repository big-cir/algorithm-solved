import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    static int N, danji = 0, answer;
    static int[][] graph, ch;

    // 12시 부터 시계방향
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void DFS(int x, int y) {
        if (graph[x][y] == 0) {
            return;
        } else {
            answer++;
            ch[x][y] = 1;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < N && graph[nx][ny] == 1 && ch[nx][ny] == 0) {
                    ch[nx][ny] = 1;
                    DFS(nx, ny);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        ch = new int[N][N];
        graph = new int[N][N];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < N; j++) {
                graph[i][j] = Integer.parseInt(input.substring(j, j+1));
            }
        }

        ArrayList<Integer> house_count = new ArrayList<>();
        // graph 에서 1로 되어있는 집 탐색하고, ch 에서 아직 탐색하지않은(ch = 0) 인 곳을 탐색
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (graph[i][j] == 1 && ch[i][j] == 0) {
                    danji++;
                    answer = 0;
                    DFS(i, j);
                    house_count.add(answer);
                    // System.out.println(answer);
                }
            }
        }
        System.out.println(danji);

        Collections.sort(house_count);
        for (int i = 0; i < house_count.size(); i++) {
            System.out.println(house_count.get(i));
        }
    }
}
