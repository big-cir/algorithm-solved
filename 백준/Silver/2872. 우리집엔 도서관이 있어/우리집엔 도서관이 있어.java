import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int maxValueIdx = 0;
        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(br.readLine());
            if (value == N) maxValueIdx = i;
            arr[i] = value;
        }

        int cnt = 1;
        int compareValue = N - 1;
        for (int i = maxValueIdx; i >= 0; i--) {
            if (arr[i] == compareValue) {
                cnt++;
                compareValue--;
            }
        }

        System.out.println(N - cnt);
    }
}
