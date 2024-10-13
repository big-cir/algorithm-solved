import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[7][N];

        divide(0, 0, N);
        
        for (int[] sub : arr) {
            boolean flag = Arrays.stream(sub).anyMatch(x -> x == 1);
            if (!flag) sub[0] = 1;

            for (int j = 0; j < N; j++) {
                if (sub[j] == 1) System.out.print("A");
                if (sub[j] == 2) System.out.print("B");
            }
            System.out.println();
        }
    }

    private static void divide(int level, int lt, int rt) {
        if (level == 7) return;

        int mid = (lt + rt) / 2;
        for (int i = lt; i < mid; i++) arr[level][i] = 1;
        for (int i = mid; i < rt; i++) arr[level][i] = 2;

        divide(level + 1, lt, mid);
        divide(level + 1, mid, rt);
    }
}