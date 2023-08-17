import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        String str = br.readLine();

        String OI = "";
        for (int i = 0; i < N; i++) {
            OI += "OI";
        }
        int answer = 0;
        int idx = 0;
        while (idx < M - 2) {
            if (str.charAt(idx) == 'I') {
                int idx2 = idx;
                String tmp = "";
                if (idx2 + 1 + (N * 2) <= M) {
                    tmp = str.substring(idx2 + 1, idx2 + 1 + (N * 2));
                } else {
                    tmp = str.substring(idx2 + 1, M - 1);
                }

                if (tmp.equals(OI)) {
                    answer++;
                }
                idx++;
            } else {
                idx++;
            }
        }
        System.out.println(answer);
    }
}