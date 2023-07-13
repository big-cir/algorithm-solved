import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, count = 0;
    static int[] P, S;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        P = new int[N];     // 정보
        S = new int[N];     // 섞는 방법

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            P[i] = Integer.parseInt(st.nextToken());
        }

        int[] pOrigin = P.clone();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            S[i] = Integer.parseInt(st.nextToken());
        }

        int[] origin = new int[N];
        int[] copy = new int[N];
        for (int i = 0; i < N; i++) {
            origin[i] = i % 3;
        }

        // default : 0 -> 0, 1 -> 1, 2 -> 2, 3 -> 0
        // [0 1 2] 형태로 가야하나?\

        boolean flag = true;
        if (!Arrays.equals(P, origin)) {
            while (flag) {
                for (int i = 0; i < N; i++) {
                    int moveIdx = S[i];
                    copy[moveIdx] = P[i];
                }

                P = copy.clone();
                count++;

                if (Arrays.equals(copy, origin)) {
                    break;
                } else if (Arrays.equals(pOrigin, P)) {
                    count = -1;
                    break;
                }
            }
        }
        System.out.println(count);
    }
}
