import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input;
        while ((input = br.readLine()) != null) {
            int N = Integer.parseInt(input);
            int size = (int) Math.pow(3, N);
            int[] ch = new int[size];
            solution(size, 0, ch);

            StringBuilder sb = new StringBuilder();
            for (int x : ch) {
                if (x == 0) sb.append("-");
                else sb.append(" ");
            }

            System.out.println(sb);
        }
    }

    private static void solution(int size, int start, int[] ch) {
        if (size == 1) return;

        int resize = size / 3;
        solution(resize, start, ch);
        for (int i = start + resize; i < start + resize * 2; i++) {
            ch[i] = 1;
        }
        solution(resize, start + resize * 2, ch);
    }
}