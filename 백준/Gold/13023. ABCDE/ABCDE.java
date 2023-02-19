import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N, M, answer = 0;
    static int[] ch;
    static ArrayList<ArrayList<Integer>> graph;

    public static void DFS(int Level, int start_v) {
        if (Level == 5) {
            answer = 1;
            return;
        } else {
            for (int i = 0; i < graph.get(start_v).size(); i++) {
                if (ch[graph.get(start_v).get(i)] == 0) {
                    ch[graph.get(start_v).get(i)] = 1;
                    DFS(Level + 1, graph.get(start_v).get(i));
                    ch[graph.get(start_v).get(i)] = 0;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        ch = new int[N];

        graph = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            graph.get(v1).add(v2);
            graph.get(v2).add(v1);
        }

        for (int i = 0; i < N; i++) {
            ch[i] = 1;
            DFS(1, i);
            ch[i] = 0;

            if (answer == 1) {
                break;
            }
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}
