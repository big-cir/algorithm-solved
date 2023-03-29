import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static int combi(int N, int M) {
        if (N == M || M == 0) {
            return 1;
        } else {
            return combi(N - 1, M - 1) + combi(N - 1, M);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        System.out.println(combi(N, M));
    }
}