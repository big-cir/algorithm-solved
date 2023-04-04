import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static int findNum(int number, int[] A) {
        int lt = 0;
        int rt = A.length;
        int mid = (lt + rt) / 2;

        while (lt < rt) {
            if (A[mid] == number) {
                return number;
            }

            if (A[mid] < number) {
                lt = mid + 1;
                mid = (lt + rt) / 2;
            } else {
                rt = mid - 1;
                mid = (lt + rt) / 2;
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);


        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        // 1
        for (int i = 0; i < M; i++) {
            int num = Arrays.binarySearch(A, Integer.parseInt(st.nextToken()));
            if (num < 0) {
                System.out.println(0);
            } else {
                System.out.println(1);
            }
        }

    }
}