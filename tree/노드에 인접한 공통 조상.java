public class Main {

    static int N;
    static List<List<Integer>> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        for (int i = 0; i <= N; i++) list.add(new ArrayList<>());
        
        int[] depth = new int[N + 1];
        int[] parent = new int[N + 1];

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            parent[v2] = v1;

            list.get(v1).add(v2);
            list.get(v2).add(v1);
        }

        int root = 0;
        for (int i = 1; i < parent.length; i++) {
            if (parent[i] == 0) {
                root = i;
                break;
            }
        }

        dfs(root, depth, new int[N + 1]);

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        while (depth[v1] != depth[v2]) {
            if (depth[v1] > depth[v2]) v1 = parent[v1];
            if (depth[v2] > depth[v1]) v2 = parent[v2];
        }

        while (v1 != v2) {
            v1 = parent[v1];
            v2 = parent[v2];
        }

        System.out.println(v1);
    }

    private static void dfs(int vertex, int[] depth, int[] ch) {
        for (int next : list.get(vertex)) {
            if (ch[next] == 0) {
                ch[next] = 1;
                depth[next] = depth[vertex] + 1;
                dfs(next, depth, ch);
            }
        }
    }
}
