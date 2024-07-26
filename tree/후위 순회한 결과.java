import java.util.*;
import java.io.*;

public class Main {

    static int N, index;
    static int[] preOrder, inOrder, postOrder;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        preOrder = new int[N + 1];
        inOrder = new int[N + 1];
        postOrder = new int[N];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            preOrder[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            inOrder[i] = Integer.parseInt(st.nextToken());
        }

        int index = 0;
        int rootIdx = 1;
        find(rootIdx, 1, N);

        StringBuilder sb = new StringBuilder();
        for (int x : postOrder) {
            sb.append(x).append(" ");
        }

        System.out.println(sb.toString());
    }

    private static void find(int rootIdx, int inLeftIdx, int inRightIdx) {
        if (inLeftIdx > inRightIdx) return;

        int inOrderRootIdx = 0;
        for (int i = inLeftIdx; i <= inRightIdx; i++) {
            if (preOrder[rootIdx] == inOrder[i]) {
                inOrderRootIdx = i;
                break;
            }
        }

        int leftRootIdx = rootIdx + 1;
        int rightRootIdx = rootIdx + inOrderRootIdx - inLeftIdx + 1;

        // left 조사
        find(leftRootIdx, inLeftIdx, inOrderRootIdx - 1);

        // right 조사
        find(rightRootIdx, inOrderRootIdx + 1, inRightIdx);

        postOrder[index++] = preOrder[rootIdx];
    }
}
