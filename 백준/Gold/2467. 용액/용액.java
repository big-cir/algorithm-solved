import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr;
    public static void solution() {
        int p1 = 0, p2 = N - 1;
        int sum = Integer.MAX_VALUE;
        int x1 = 0, x2 = 0;

        while (p1 < p2) {
            int tmp = Math.abs(arr[p1] + arr[p2]);
            if (sum > tmp) {
                x1 = p1;
                x2 = p2;
                sum = tmp;
            }

            if (arr[p1] + arr[p2] > 0) {
                p2--;
            } else {
                p1++;
            }
        }

        System.out.println(arr[x1] +  " " + arr[x2]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        solution();
    }
}