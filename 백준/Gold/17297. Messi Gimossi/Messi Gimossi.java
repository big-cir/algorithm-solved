import java.io.*;
import java.util.*;

public class Main {
    static long M;
    static Map<Integer, Long> dp;
    static String answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        M = Long.parseLong(br.readLine());
        dp = new HashMap<>();
        dp.put(1, 5L);
        dp.put(2, 13L);
        
        if (M <= 13) {
            if (M <= 5) {
                System.out.println("Messi".charAt((int) M - 1));
            } else if (M == 6) {
                System.out.println("Messi Messi Gimossi");
            } else {
                System.out.println("Gimossi".charAt((int) M - 7));
            }
            return;
        }

        int N = 3;
        while (true) {
            long size = dp.get(N - 1) + 1 + dp.get(N - 2);
            if (size >= M) {
                break;
            } else {
                dp.put(N, size);
                N++;
            }
        }

        solution(N, M);
        System.out.println(answer);
    }

    private static void solution(int N, long length) {
        if (N <= 2) {
            if (N == 1) {
                answer = String.valueOf("Messi".charAt((int) length - 1));
            } else {
                if (length <= 13) {
                    if (length <= 5) {
                        answer = String.valueOf("Messi".charAt((int) length - 1));   
                    } else if (length == 6) {
                        answer = "Messi Messi Gimossi";
                    } else {
                        answer = String.valueOf("Gimossi".charAt((int) length - 7));
                    }
                }
            }

            return;
        }

        long prevLen1 = dp.get(N - 1);

        if (length <= prevLen1) {
            solution(N - 1, length);
        } else if (length == prevLen1 + 1) {
            answer = "Messi Messi Gimossi";
        } else {
            solution(N - 2, length - prevLen1 - 1);
        }
    }
}