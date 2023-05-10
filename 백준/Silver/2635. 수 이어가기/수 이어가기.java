import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int max = 0;
        int middle = 0;

        for (int i = N; i >= 0; i-- ) {
            int count = 2;
            int nextNum = i;
            int middleNum = N - nextNum;
            int tmp = 0;

            while (tmp >= 0) {
                count++;
                tmp = nextNum - middleNum;
                nextNum = middleNum;
                middleNum = tmp;
            }

            if (max < count) {
                max = count;
                middle = i;
            }
        }
        System.out.println(max);

        int tmp = middle;
        while (N >= 0) {
            System.out.print(N + " ");
            tmp = N - middle;
            N = middle;
            middle = tmp;
        }
    }
}