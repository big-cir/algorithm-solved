import java.awt.*;
import java.io.*;
import java.util.*;
import java.util.List;

public class Main {

    static int N;
    static List<List<Integer>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        int[] edges = new int[N + 1];
        StringTokenizer st;
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            edges[v1]++;
            edges[v2]++;
            graph.get(v1).add(v2);
        }

        long dCnt = 0;
        long gCnt = 0;
        int conLine = 3;
        for (int i = 1; i <= N; i++) {
            int value = edges[i];
            if (value >= 3) {
                gCnt += (long) value * (value - 1) * (value - 2) / (conLine * (conLine - 1));
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int next : graph.get(i)) {
                dCnt +=  ((long) edges[i] - 1) * ((long) edges[next] - 1);
            }
        }

        if (dCnt > 3 * gCnt) System.out.println("D");
        else if (dCnt < 3 * gCnt) System.out.println("G");
        else if (dCnt == 3 * gCnt) System.out.println("DUDUDUNGA");
    }
}