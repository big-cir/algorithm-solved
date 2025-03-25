import java.io.*;
import java.util.*;

public class Main {

    static long[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        arr = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        Arrays.sort(arr);

        long answer = 0;
        int cnt = 0;
        int lt = 0;
        long less = 0;
        int rt = N - 1;
        while (cnt != M) {
            if (cnt % 2 == 0) {
                answer += (arr[rt--] - less);
            } else {
                less = arr[lt++];
            }

            cnt++;
        }

        System.out.println(answer);
    }
}
