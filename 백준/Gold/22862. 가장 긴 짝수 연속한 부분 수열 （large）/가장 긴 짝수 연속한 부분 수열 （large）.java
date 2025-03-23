import java.io.*;
import java.util.*;

public class Main {

    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int answer = 0;
        int lt = 0;
        int tmp = 0;
        for (int rt = 0; rt < N; rt++) {
            if (arr[rt] % 2 != 0) {
                tmp++;
            }

            while (tmp > M) {
                if (arr[lt] % 2 != 0) tmp--;
                lt++;
            }

            answer = Math.max(answer, rt - lt - tmp + 1);
        }

        System.out.println(answer);
    }
}

