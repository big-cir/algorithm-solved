import java.io.*;
import java.util.*;

public class Main {
    static int N;

    static class Node {
        private Map<String, Node> childs;

        public Node() {
            childs = new HashMap<>();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        Node root = new Node();
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            Node tree = root;

            for (int j = 0; j < cnt; j++) {
                String str = st.nextToken();

                if (!tree.childs.containsKey(str)) {
                    tree.childs.put(str, new Node());
                }
                tree = tree.childs.get(str);
            }
        }

        StringBuilder sb = new StringBuilder();
        dfs(sb, root, "");
        System.out.println(sb);
    }

    private static void dfs(StringBuilder sb, Node tree, String hypen) {
        Set<String> keys = tree.childs.keySet();
        List<String> list = new ArrayList<>(keys);
        Collections.sort(list);

        for (String str : list) {
            sb.append(hypen).append(str).append("\n");
            dfs(sb, tree.childs.get(str), hypen + "--");
        }
    }
}