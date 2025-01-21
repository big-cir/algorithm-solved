import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static final long MAX = 9876543210L;
    static List<Long> list;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        list = new ArrayList<>();
        for (int num = 0; num < 10; num++) {
            getNum(num);
        }
        Collections.sort(list);
        if (N > 1022) System.out.println(-1);
        else System.out.println(list.get(N));
    }

    private static void getNum(long num) {
        if (num > MAX) return;
        list.add(num);

        for (int next = 0; next < 10; next++) {
            if (num % 10 > next) {
                getNum(num * 10 + next);
            }
        }
    }
}