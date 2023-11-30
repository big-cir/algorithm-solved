import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int N, M;
    static int[] arrN, arrM;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arrN = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        M = Integer.parseInt(br.readLine());
        arrM = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Arrays.sort(arrN);
        for (int target : arrM) {
            if (binarySearch(target)) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }

    private static boolean binarySearch(int target) {
        int lt = 0;
        int rt = N - 1;
        while (lt <= rt) {
            int midIdx = (lt + rt) / 2;

            if (arrN[midIdx] == target) return true;

            if (arrN[midIdx] < target) {
                lt = midIdx + 1;
            } else {
                rt = midIdx - 1;
            }
        }
        return false;
    }
}
