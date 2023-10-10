import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static Map<String, Node> tree;

    static class Node {
        String parent;
        Node lt;
        Node rt;

        public Node(String parent) {
            this.parent = parent;
            this.lt = null;
            this.rt = null;
        }

        public void setChild(Node lt, Node rt) {
            this.lt = lt;
            this.rt = rt;
        }

        public String getParent() {
            return parent;
        }

        public Node getLt() {
            return lt;
        }

        public Node getRt() {
            return rt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        tree = new HashMap<>();
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String parent = st.nextToken();
            String lt = st.nextToken();
            String rt = st.nextToken();
            Node node = new Node(parent);
            node.setChild(new Node(lt), new Node(rt));

            tree.put(parent, node);
        }
        StringBuilder sb = new StringBuilder();
        preOrder("A", sb);
        sb.append("\n");

        inOrder("A", sb);
        sb.append("\n");

        postOrder("A", sb);
        sb.append("\n");

        System.out.println(sb);
    }

    public static void preOrder(String parent, StringBuilder sb) {
        if (parent.equals(".")) {
            return;
        }
        Node childNode = tree.get(parent);
        sb.append(parent);
        preOrder(childNode.lt.getParent(), sb);
        preOrder(childNode.rt.getParent(), sb);
    }

    public static void inOrder(String parent, StringBuilder sb) {
        if (parent.equals(".")) {
            return;
        }
        Node childNode = tree.get(parent);
        inOrder(childNode.lt.getParent(), sb);
        sb.append(parent);
        inOrder(childNode.rt.getParent(), sb);
    }

    public static void postOrder(String parent, StringBuilder sb) {
        if (parent.equals(".")) {
            return;
        }
        Node childNode = tree.get(parent);
        postOrder(childNode.lt.getParent(), sb);
        postOrder(childNode.rt.getParent(), sb);
        sb.append(parent);
    }
}
