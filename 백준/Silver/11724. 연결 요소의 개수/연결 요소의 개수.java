import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int answer = 0, N, M;
    static int[] visit;
    static ArrayList<ArrayList<Integer>> list;

    public static void DFS(int vertex) {
        if (visit[vertex] == 1) {
            return;
        } else {
            visit[vertex] = 1;
            for (int i : list.get(vertex)) {
                if (visit[i] == 0) {
                    DFS(i);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visit = new int[N + 1];

        list = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            list.get(u).add(v);
            list.get(v).add(u);
        }

        for (int i = 1; i <= N; i++) {
            if (visit[i] != 1) {
                answer++;
                DFS(i);
            }
        }

        System.out.println(answer);
    }
}
