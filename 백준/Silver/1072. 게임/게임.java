import java.util.*;
import java.io.*;

public class Main {

    static long X, Y;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        X = Long.parseLong(st.nextToken());
        Y = Long.parseLong(st.nextToken());

        double init = Y * 100 / X;
        if (init >= 99) {
            System.out.println(-1);
            return;
        }

        long lt = 1;
        long rt = 2000000000;
        while (lt <= rt) {
            long mid = (lt + rt) / 2;
            double result = (Y + mid) * 100 / (X + mid);

            if (result <= init) {
                lt = mid + 1;
            } else {
                rt = mid - 1;
            }
        }

        System.out.println(lt);
    }
}