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
        for (long key : ab) {
            int upper = upperBound(cd, -key);
            int lower = lowerBound(cd, -key);
            answer += (upper - lower);
        }

        System.out.println(answer);
    }

    static int upperBound(int[] arr, long find) {
        int left = 0;
        int right = arr.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] <= find) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right;
    }

    static int lowerBound(int[] arr, long find) {
        int left = 0;
        int right = arr.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (arr[mid] < find) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right;
    }
}