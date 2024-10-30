import java.util.*;
import java.io.*;

public class Main {

    static int N, d, k, c, answer;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        N = info[0];
        d = info[1];
        k = info[2];
        c = info[3];
        arr = new int[N];
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(br.readLine());


        int lt = 0;
        int[] ate;
        while (lt < N) {
            int cnt = 1;
            ate = new int[d + 1];
            ate[arr[lt]] = 1;
            ate[c] = 1;

            int rt = lt + 1;
            while (true) {
                if (rt == N) rt = 0;
                if (cnt == k) {
                    int ateCnt = 0;
                    for (int i = 1; i <= d; i++) {
                        if (ate[i] == 1) ateCnt++;
                    }

                    answer = Math.max(answer, ateCnt);
                    lt++;
                    if (lt == N - 1) rt = 0;
                    break;
                }
                ate[arr[rt]] = 1;
                cnt++;
                rt++;
            }
        }

        System.out.println(answer);
    }
}