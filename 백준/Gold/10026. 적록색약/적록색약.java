import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int N;
    static int[][] graph, ch, dxdy = {{-1, 0}, {0,1}, {1,0}, {0, -1}};
    static int[] t_case;

    static void DFS(int x, int y, int rgb_value) {
        ch[x][y] = 1;
        for (int i = 0; i < 4; i++) {
            int nx = x + dxdy[i][0];
            int ny = y + dxdy[i][1];

            if (nx >= 0 && nx < N && ny >= 0 && ny < N && graph[nx][ny] == rgb_value && ch[nx][ny] == 0) {
                DFS(nx, ny, rgb_value);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];
        ch = new int[N][N];
        t_case = new int[] {0, 0};

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                if (str.substring(j, j + 1).equals("R")) {
                    graph[i][j] = 3;
                } else if (str.substring(j, j + 1).equals("B")) {
                    graph[i][j] = 2;
                } else {
                    graph[i][j] = 1;
                }
            }
        }

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (ch[j][k] == 0) {
                        int rgb_val = graph[j][k];
                        DFS(j, k, rgb_val);
                        t_case[i]++;
                    }

                    if (graph[j][k] == 3) {
                        graph[j][k] = 1;
                    }
                }
            }
            for (int[] x : ch) {
                Arrays.fill(x, 0);
            }
            System.out.print(t_case[i] + " ");
        }
    }
}
