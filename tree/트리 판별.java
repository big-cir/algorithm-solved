import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, count;
    static int[] ch;
    static List<List<Integer>> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        for (int i = 0; i < 10001; i++) list.add(new ArrayList<>());

        ch = new int[10001];
        StringTokenizer st;
        int start = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            list.get(v1).add(v2);
            list.get(v2).add(v1);
            ch[v2]++;
            start = v1;
        }

        boolean flag = true;
        for (int i = 1; i < 10001; i++) {
            if (ch[i] >= 2) {
                flag = false;
            }
        }

        ch = new int[10001];
        ch[start] = 1;
        dfs(start);
        
        if (count == N && flag) System.out.println(1);
        else System.out.println(0);
    }

    private static void dfs(int vertex) {
        for (int next : list.get(vertex)) {
            if (ch[next] == 0) {
                count++;
                ch[next] = 1;
                dfs(next);
            }
        }
    }
}
