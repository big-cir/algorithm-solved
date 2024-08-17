import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, K, valueIdx;
    static int[] tree, inOrderResult;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        N = (int) Math.pow(2, K) - 1;

        inOrderResult = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            inOrderResult[i + 1] = Integer.parseInt(st.nextToken());
        }

        tree = new int[N + 1];
        valueIdx = 1;
        int treeIdx = 1;
        inOrder(treeIdx);

        for (int i = 1; i <= K; i++) {
            for (int j = (int) Math.pow(2, i - 1); j <= (int) Math.pow(2, i) - 1; j++) {
                System.out.print(tree[j] + " ");
            }
            System.out.println();
        }
    }

    private static void inOrder(int treeIdx) {
        if (treeIdx > N) return;
        inOrder(treeIdx * 2); 
        tree[treeIdx] = inOrderResult[valueIdx++];
        inOrder(treeIdx * 2 + 1);
    }
}
