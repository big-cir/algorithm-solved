import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][4];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] ab = new int[N * N];
        int[] cd = new int[N * N];
        int idx = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                ab[idx] = arr[i][0] + arr[j][1];
                cd[idx] = arr[i][2] + arr[j][3];
                idx++;
            }
        }
        Arrays.sort(cd);

        long answer = 0;
        for (long target : ab) {
            int upper = upperBound(cd, target);
            int lower = lowerBound(cd, target);
            answer += (upper - lower);
        }

        System.out.println(answer);
    }

    static int upperBound(int[] arr, long target) {
        int lt = 0;
        int rt = N * N;
        while (lt < rt) {
            int mid = (lt + rt) / 2;
            long comp = arr[mid];
            
            if (comp + target <= 0) {
                lt = mid + 1;
            } else {
                rt = mid;
            }
        }
        return rt;
    }

    static int lowerBound(int[] arr, long target) {
        int lt = 0;
        int rt = N * N;
        while (lt < rt) {
            int mid = (lt + rt) / 2;
            long comp = arr[mid];
            
            if (comp + target < 0) {
                lt = mid + 1;
            } else {
                rt = mid;
            }
        }
        return rt;
    }
}