import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();

        int n = Integer.parseInt(N, 3);
        n *= 22;

        String answer = Integer.toString(n, 3);
        System.out.println(answer);
    }
}
