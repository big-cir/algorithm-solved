import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int count = 0;
    static StringBuilder sb;
    public static void recursive(int n, int start, int mid, int arrive) {
        if (n == 1) {
            sb.append(start + " " + arrive + "\n");
            count++;
            return;
        }

        recursive(n - 1, start, arrive, mid);
        sb.append(start + " " + arrive + "\n");
        count++;
        recursive(n - 1, mid, start, arrive);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        sb = new StringBuilder();
        recursive(N, 1, 2, 3);
        System.out.println(count);
        System.out.println(sb.toString());
    }
}
