import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    static int sum, N;
    static boolean flag = true;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = 9;
        sum = 0;
        ArrayList<Integer> answer = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int ip = Integer.parseInt(br.readLine());
            sum += ip;
            answer.add(ip);
        }

        Collections.sort(answer);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == j) continue;
                int tmp = answer.get(i) + answer.get(j);
                if (sum - tmp == 100) {
                    answer.remove(i);
                    answer.remove(j - 1);
                    flag = false;
                    break;
                }
            }
            if (!flag) break;
        }

        for (int x : answer) {
            System.out.println(x);
        }
    }
}
