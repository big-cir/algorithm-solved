import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N;
    static int[][] graph, dis;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];
        dis = new int[N][N];

        for (int i = 0; i < N; i++) {
            graph[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        // i -> k -> j
        // k : 거쳐가는 노드
        for (int k = 0; k < N; k++) {
            // i = 출발 정점
            for (int i = 0; i < N; i++) {
                // j = 도착 정점
                for (int j = 0; j < N; j++) {
                    // (0, 1) (1, 2)
                    // i -> 1 -> j
                    if (graph[i][k] == 1 && graph[k][j] == 1) {
                        graph[i][j] = 1;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int[] arr : graph) {
            for (int x : arr) {
                sb.append(x).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}