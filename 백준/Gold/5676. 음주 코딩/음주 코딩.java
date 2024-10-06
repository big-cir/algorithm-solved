import java.util.*;
import java.io.*;

public class Main {

    static int[] tree, arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        StringTokenizer st;

        while ((str = br.readLine()) != null) {
            st = new StringTokenizer(str);
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            arr = new int[N + 1];

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            double height = Math.ceil(Math.log(N) / Math.log(2)) + 1;
            int treeNodeCount = (int) Math.round(Math.pow(2, height));
            tree = new int[treeNodeCount];

            init(1, 1, N);

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                String command = st.nextToken();

                if (command.equals("C")) {
                    int idx = Integer.parseInt(st.nextToken());
                    int value = Integer.parseInt(st.nextToken());
                    update(1, 1, N, idx, value);
                } else {
                    int startIdx = Integer.parseInt(st.nextToken());
                    int endIdx = Integer.parseInt(st.nextToken());
                    int result = multi(1, 1, N, startIdx, endIdx);

                    System.out.print(result == 0 ? 0 : result > 0 ? "+" : "-");
                }
            }
            System.out.println();
        }
    }

    private static int init(int sIdx, int start, int end) {
        if (start == end) {
            return tree[sIdx] = arr[start] > 0 ? 1 : arr[start] < 0 ? -1 : 0;
        } else {
            int mid = (start + end) / 2;
            return tree[sIdx] = init(sIdx * 2, start, mid)
                    * init(sIdx * 2 + 1, mid + 1, end);
        }
    }

    private static int update(int sIdx, int start, int end, int index, int value) {
        if (index < start || end < index) return tree[sIdx];
        else if (index == start && index == end) return tree[sIdx] = value > 0 ? 1 : value < 0 ? -1 : 0;
        else return tree[sIdx] = update(sIdx * 2, start, (start + end) / 2, index, value)
            * update(sIdx * 2 + 1, (start + end) / 2 + 1, end, index, value);
    }

    private static int multi(int sIdx, int start, int end, int lt, int rt) {
        if (end < lt || start > rt) return 1;
        else if (lt <= start && rt >= end) return tree[sIdx];
        else return multi(sIdx * 2, start, (start + end) / 2, lt, rt)
            * multi(sIdx * 2 + 1, (start + end) / 2 + 1, end, lt, rt);
    }
}