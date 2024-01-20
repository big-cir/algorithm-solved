import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        int[] mon = new int[13];
        String[] yoil = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
        for (int i = 1; i < 13; i++) {
            if (i == 4 || i == 6 || i == 9 || i == 11) {
                mon[i] = 30;
            } else if (i == 2) {
                mon[i] = 28;
            } else {
                mon[i] = 31;
            }
        }

        for (int i = 1; i <= m - 1; i++) {
            d += mon[i];
        }

        System.out.println(yoil[d % 7]);
    }
}
