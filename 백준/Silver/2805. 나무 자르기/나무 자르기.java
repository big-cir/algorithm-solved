import java.io.*;
import java.util.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long answer = 0;
        long lt = 0;
        long rt = Arrays.stream(arr).max().getAsInt();
        while (lt <= rt) {
            long mid = (lt + rt) / 2;
            long sum = 0;
            for (int i = 0; i < N; i++) {
                long gap = arr[i] - mid;
                if (gap > 0) sum += gap;
            }

            if (M > sum) {
                rt = mid - 1;
            } else {
                answer = Math.max(answer, mid);
                lt = mid + 1;
            }
        }

        System.out.println(answer);
    }
}
