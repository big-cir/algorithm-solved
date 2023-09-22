import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] x = new int[3];
        int[] y = new int[3];

        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(CCW(x, y));
    }

    public static int CCW(int[] x, int[] y) {
        if (((x[0] * y[1]) + (x[1] * y[2]) + (x[2] * y[0])) -
                ((y[0] * x[1]) + (y[1] * x[2]) + (y[2] * x[0])) == 0) {
            return 0;
        } else if (((x[0] * y[1]) + (x[1] * y[2]) + (x[2] * y[0])) -
                ((y[0] * x[1]) + (y[1] * x[2]) + (y[2] * x[0])) > 0) {
            return 1;
        }

        return -1;
    }
}
