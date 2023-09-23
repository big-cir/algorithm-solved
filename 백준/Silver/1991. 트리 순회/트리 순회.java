import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Node{
    char left, right;
    public Node(char left, char right){
        this.left = left;
        this.right = right;
    }
}

public class Main {

    public static List<Node>[] list;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        list = new List[N+1];

        for(int i=1; i<=N; ++i){
            list[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for(int i=1; i<=N; ++i){
            st = new StringTokenizer(br.readLine());

            int data = st.nextToken().charAt(0) - '@'; // 'A' - '@' == 'A' - 'A' + 1 == 1
            char l = st.nextToken().charAt(0);
            char r = st.nextToken().charAt(0);
            list[data].add(new Node(l, r));
        }

        preorder(1);
        sb.append("\n");
        inorder(1);
        sb.append("\n");
        postorder(1);
        sb.append("\n");
        System.out.println(sb);

    }

    static void preorder(int start){
        for(Node node: list[start]){
            char l = node.left;
            char r = node.right;

            sb.append((char)(start+'@'));
            if(l != '.') preorder(l-'@');
            if(r != '.') preorder(r-'@');
        }
    }

    static void inorder(int start) {
        for(Node node : list[start]) {
            char l = node.left;
            char r = node.right;

            if(l != '.') inorder(l-'@');
            sb.append((char)(start+'@'));
            if(r != '.') inorder(r-'@');
        }
    }

    static void postorder(int start) {
        for(Node node : list[start]) {
            char l = node.left;
            char r = node.right;

            if(l != '.') postorder(l-'@');
            if(r != '.') postorder(r-'@');
            sb.append((char)(start+'@'));
        }
    }
}