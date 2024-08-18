import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, idx;
    static int[] preResult, inResult, postResult;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for (int i = 0; i < tc; i++) {
            N = Integer.parseInt(br.readLine());
            preResult = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            inResult = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            postResult = new int[N];

            idx = 0;
            postOrder(0, 0, N - 1);

            for (int x : postResult) System.out.print(x + " ");
            System.out.println();
        }
    }

    private static void postOrder(int rootIdx, int lt, int rt) {
        if (lt > rt) return;

        int inRootIdx = 0;
        for (int i = lt; i <= rt; i++) {
            if (preResult[rootIdx] == inResult[i]) {
                inRootIdx = i;
                break;
            }
        }

        int ltRootIdx = rootIdx + 1;
        int rtRootIdx = rootIdx + inRootIdx - lt + 1;

        postOrder(ltRootIdx, lt, inRootIdx - 1);
        postOrder(rtRootIdx, inRootIdx + 1, rt);
        postResult[idx++] = preResult[rootIdx];
    }

}