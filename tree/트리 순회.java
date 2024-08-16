import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Node {
        String parent;
        Node left;
        Node right;

        public Node(String parent, Node left, Node right) {
            this.parent = parent;
            this.left = left;
            this.right = right;
        }
        public void setLeft(Node left) {
            this.left = left;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }

    static int N;
    static StringBuilder sb;
    static Map<String, Node> tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        tree = new HashMap<>();

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String parent = st.nextToken();
            String left = st.nextToken();
            String right = st.nextToken();

            Node node = new Node(parent, null, null);
            Node lt = new Node(left, null, null);
            Node rt = new Node(right, null, null);
            node.setLeft(lt);
            node.setRight(rt);

            tree.put(parent, node);
        }

        sb = new StringBuilder();
        preOrder("A");
        sb.append("\n");

        inOrder("A");
        sb.append("\n");

        postOrder("A");
        System.out.println(sb.toString());
    }

    private static void preOrder(String parent) {
        if (parent.equals(".")) return;
        Node node = tree.get(parent);

        sb.append(node.parent);
        preOrder(node.left.parent);
        preOrder(node.right.parent);
    }

    private static void inOrder(String parent) {
        if (parent.equals(".")) return;
        Node node = tree.get(parent);

        inOrder(node.left.parent);
        sb.append(node.parent);
        inOrder(node.right.parent);
    }

    private static void postOrder(String parent) {
        if (parent.equals(".")) return;
        Node node = tree.get(parent);

        postOrder(node.left.parent);
        postOrder(node.right.parent);
        sb.append(node.parent);
    }
}
