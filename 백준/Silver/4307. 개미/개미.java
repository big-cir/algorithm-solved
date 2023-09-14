import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i = 0; i < tc; i++) {
            st = new StringTokenizer(br.readLine());
            int l = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            int min = 0, max = 0;
            for (int j = 0; j < n; j++) {
                int ant = Integer.parseInt(br.readLine());
                int tmp = Math.min(ant, l - ant);
                min = Math.max(min, tmp);

                max = Math.max(ant, max);
                max = Math.max(max, l - ant);
            }

            System.out.println(min + " " + max);
        }
    }
}