import java.util.*;
import java.io.*;

public class Main {

    static class Node {
        int min;
        int max;

        public Node(int min, int max) {
            this.min = min;
            this.max = max;
        }
    }

    static class SegmentTree {
        Node[] tree;

        public SegmentTree(int arrSize) {
            this.tree = new Node[arrSize * 4];
        }

        public Node init(int[] arr, int node, int start, int end) {
            if (start == end) {
                return tree[node] = new Node(arr[start], arr[end]);
            } else {
                int mid = (start + end) / 2;
                Node c1 = init(arr, node * 2, start, mid);
                Node c2 = init(arr, node * 2 + 1, mid + 1, end);
                return tree[node] = new Node(
                        Math.min(c1.min, c2.min),
                        Math.max(c1.max, c2.max)
                );
            }
        }

        public Node find(int node, int start, int end, int lt, int rt) {
            if (lt > end || rt < start) {
                return new Node(Integer.MAX_VALUE, Integer.MIN_VALUE);
            } else if (lt <= start && end <= rt) {
                return tree[node];
            } else {
                int mid = (start + end) / 2;
                Node c1 = find(node * 2, start, mid, lt, rt);
                Node c2 = find(node * 2 + 1, mid + 1, end, lt, rt);
                return new Node(
                    Math.min(c1.min, c2.min),
                    Math.max(c1.max, c2.max)
                );
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        SegmentTree tree = new SegmentTree(N);
        tree.init(arr, 1, 1, N);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int lt = Integer.parseInt(st.nextToken());
            int rt = Integer.parseInt(st.nextToken());
            
            Node result = tree.find(1, 1, N, lt, rt);
            System.out.println(result.min + " " + result.max);
        }
    }
}