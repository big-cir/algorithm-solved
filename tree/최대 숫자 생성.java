import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static String[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new String[N];
        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }
        
        Arrays.sort(arr, (a, b) -> {
            String comp1 = a + b;
            String comp2 = b + a;
            return comp2.compareTo(comp1);
        });

        StringBuilder sb = new StringBuilder();
        for (String s : arr) {
            sb.append(s);
        }

        System.out.println(sb);
    }
}
