import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();

    static class Node {
        private char lt, rt;

        public Node(char lt, char rt) {
            this.lt = lt;
            this.rt = rt;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Map<Character, Node> map = new HashMap<>();

        StringTokenizer st;
        // . == 46
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            char data = st.nextToken().charAt(0);
            char lt = st.nextToken().charAt(0);
            char rt = st.nextToken().charAt(0);
            map.put(data, new Node(lt, rt));
        }

        preOrder(map, 'A');
        sb.append("\n");
        inOrder(map, 'A');
        sb.append("\n");
        postOrder(map, 'A');
        System.out.println(sb.toString());
    }

    public static void preOrder(Map<Character, Node> map, Character parent) {
        if (parent == '.') return;
        sb.append(parent);
        Node childNode = map.get(parent);
        preOrder(map, childNode.lt);
        preOrder(map, childNode.rt);
    }

    public static void inOrder(Map<Character, Node> map, Character parent) {
        if (parent == '.') return;
        Node childNode = map.get(parent);
        inOrder(map, childNode.lt);
        sb.append(parent);
        inOrder(map, childNode.rt);
    }

    public static void postOrder(Map<Character, Node> map, Character parent) {
        if (parent == '.') return;
        Node childNode = map.get(parent);
        postOrder(map, childNode.lt);
        postOrder(map, childNode.rt);
        sb.append(parent);
    }
}

