import java.util.*;
import java.io.*;

public class Main {

    static class SegmentTree {
        long[] tree;

        public SegmentTree(int arrSize) {
            this.tree = new long[arrSize * 4];
        }

        public long init(long[] arr, int node, int start, int end) {
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
            if (lt > end || rt < start) {
                return 0;
            } else if (lt <= start && end <= rt) {
                return tree[node];
            } else {
                int mid = (start + end) / 2;
                long l1 = sum(node * 2, start, mid, lt, rt);
                long l2 = sum(node * 2 + 1, mid + 1, end, lt, rt);
                return l1 + l2;
            }
        }

        public long update(int node, int start, int end, int targetNode, long changeValue) {
            if (targetNode < start || targetNode > end) {
                return tree[node];
            } else if (start == targetNode && end == targetNode) {
                return tree[node] = changeValue;
            } else {
                int mid = (start + end) / 2;
                long l1 = update(node * 2, start, mid, targetNode, changeValue);
                long l2 = update(node * 2 + 1, mid + 1, end, targetNode, changeValue);
                return tree[node] = l1 + l2;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        long[] arr = new long[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        SegmentTree tree = new SegmentTree(N);
        tree.init(arr, 1, 1, N);

        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());


            if (a == 1) {
                long c = Long.parseLong(st.nextToken());
                tree.update(1, 1, N, b, c);
            } else {
                int c = Integer.parseInt(st.nextToken());
                long sum = tree.sum(1, 1, N, b, c);
                System.out.println(sum);
            }
        }
    }
}