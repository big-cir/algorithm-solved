import java.util.*;
import java.io.*;
public class Main {

    public static int sub(int[] A, int mid) {
        int blueRay = 1;
        int sum = 0;

        for (int x : A) {
            if (sum + x> mid) {
                blueRay++;
                sum = x;
            } else {
                sum += x;
            }
        }
        return blueRay;
    }

    public static int binary(int[] A, int M) {
        int answer = 0;
        int lt = Arrays.stream(A).max().getAsInt();
        int rt = Arrays.stream(A).sum();

        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if (sub(A, mid) <= M) {
                answer = mid;
                rt = mid - 1;
            } else {
                lt = mid + 1;
            }
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] A = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(binary(A, M));


    }
}
