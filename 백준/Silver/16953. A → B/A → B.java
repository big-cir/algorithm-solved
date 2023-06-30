import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int count = 1;

        while (A != B) {
            if (B < A) {
                count = -1;
                break;
            }
            if (B % 10 == 1) {
                count++;
                B /= 10;
            } else if (B % 2 == 0) {
                count++;
                B /= 2;
            } else {
                count = -1;
                break;
            }
            
        }
        System.out.println(count);
    }
}
