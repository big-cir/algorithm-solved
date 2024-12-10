import java.io.*;
import java.util.*;

public class Main {

    // index, length
    static Map<Integer, Long> dp;
    static long N;
    static String answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Long.parseLong(br.readLine());
        dp = new HashMap<>();
        dp.put(0, 3L);
        dp.put(1, 10L);
        dp.put(2, 25L);

        int index = 2;
        while (true) {
            long size = 2 * dp.get(index - 1) + dp.get(0) + index;
            if (size >= N) break;
            dp.put(index, size);
            index++;
        }

        solution(index, N);
        System.out.println(answer);
    }

    private static void solution(int index, long length) {
        if (index == 0) {
            answer = String.valueOf("moo".charAt((int) length - 1));
            return;
        }

        // 앞 부분의 길이
        long prevLen = dp.get(index - 1);
        if (prevLen >= length) {
            solution(index - 1, length);
        }
        // 뒷부분
        else if (length > prevLen + dp.get(0) + index) {
            solution(index - 1, length - (prevLen + dp.get(0) + index));
        }
        // 중간 부분
        else {
            solution(index - 1, (length - index) / 2);
        }
    }
}