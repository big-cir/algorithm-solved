import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while (true) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());

            if (N == 0) break;

            int[] arr = new int[N];
            int[] ch = new int[N];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < arr.length; i++) {
                ch[i] = 1;
                recur(0, arr[i] + " ", arr, ch, i + 1);
                ch[i] = 0;
            }
            System.out.println();
        }
    }

    public static void recur(int Level, String str, int[] arr, int[] ch, int idx) {
        if (Level == 5) {
            System.out.println(str);
            return;
        }

        for (int i = idx; i < arr.length; i++) {
            if (ch[i] == 0) {
                ch[i] = 1;
                recur(Level + 1, str + arr[i] + " ", arr, ch, i + 1);
                ch[i] = 0;
            }
        }
    }
}
