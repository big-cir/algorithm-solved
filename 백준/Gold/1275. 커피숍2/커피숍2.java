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
        long[] tree;

        public SegmentTree(int arrSize) {
            this.tree = new long[arrSize * 4];
        }

        public long init(int[] arr, int node, int start, int end) {
            if (start == end) {
                return tree[node] = arr[start];
            } else {
                int mid = (start + end) / 2;
                long l1 = init(arr, node * 2, start, mid);
                long l2 = init(arr, node * 2 + 1, mid + 1, end);
                return tree[node] = l1 + l2;
            }
        }

        public long sum(int node, int start, int end, int lt, int rt) {
            if (lt > end || start > rt) {
                return 0;
            } else if (lt <= start && end <= rt) {
                return tree[node];
            } else {
                int mid = (start + end) / 2;
                long l1 = sum(node * 2, start, mid, lt, rt);
                long l2 = sum( node * 2 + 1, mid + 1, end, lt, rt);
                return l1 + l2;
            }
        }

        public long update(int node, int targetNode, int start, int end, long changeValue) {
            if (targetNode < start || targetNode > end) return tree[node];
            else if (targetNode == start && targetNode == end) {
                return tree[node] = changeValue;
            } else {
                int mid = (start + end) / 2;
                long l1 = update(node * 2, targetNode, start, mid, changeValue);
                long l2 = update(node * 2 + 1, targetNode, mid + 1, end, changeValue);
                return tree[node] = l1 + l2;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        int[] arr = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        SegmentTree tree = new SegmentTree(N);
        tree.init(arr, 1, 1, N);

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            long b = Integer.parseInt(st.nextToken());

            long result = 0;
            if (x >= y) {
                result = tree.sum(1, 1, N, y, x);
            } else {
                result = tree.sum(1, 1, N, x, y);
            }

            tree.update(1, a, 1, N, b);
            System.out.println(result);
        }
    }
}