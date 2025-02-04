import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static List<List<int[]>> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        StringTokenizer st;
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            list.get(v1).add(new int[] {v2, cost});
            list.get(v2).add(new int[] {v1, cost});
        }

        int[] ch = new int[N + 1];
        int[] dis = new int[N + 1];
        ch[1] = 1;
        dfs(1, ch, dis);

        int maxIdx = -1;
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= N; i++) {
            if (dis[i] > max) {
                max = dis[i];
                maxIdx = i;
            }
        }

        Arrays.fill(ch, 0);
        Arrays.fill(dis, 0);
        ch[maxIdx] = 1;
        dfs(maxIdx, ch, dis);

        System.out.println(Arrays.stream(dis).max().getAsInt());
    }

    private static void dfs(int node, int[] ch, int[] dis) {
        for (int[] next : list.get(node)) {
            int nextV = next[0];
            int cost = next[1];
            if (ch[nextV] == 0) {
                ch[nextV] = 1;
                dis[nextV] += dis[node] + cost;
                dfs(nextV, ch, dis);
            }
        }
    }
}
