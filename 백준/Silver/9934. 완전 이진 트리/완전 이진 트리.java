import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int K, nodeCount;
    static int[] arr;
    static int[][] answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        nodeCount = (int) Math.pow(2, K) - 1;
        arr = new int[nodeCount];
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        answer = new int[K][nodeCount];

        recursive(0, arr.length - 1, 0);
        for (int i = 0; i < K; i++) {
            for (int j = 0; j < nodeCount; j++) {
                if (answer[i][j] == 0) continue;
                System.out.print(answer[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void recursive(int start, int end, int Level) {
        if (Level == K) {
            return;
        }

        int mid = (start + end) / 2;
        answer[Level][mid] = arr[mid];

        recursive(start, mid, Level + 1);
        recursive(mid + 1, end, Level + 1);
    }
}
