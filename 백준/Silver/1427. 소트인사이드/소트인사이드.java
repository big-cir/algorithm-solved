import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static String solution(int[] answer) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < answer.length; i++) {
            int max = i;
            for (int j = i + 1; j < answer.length; j++) {
                if (answer[j] > answer[max]) {
                    max = j;
                }
            }
            if (answer[i] < answer[max]) {
                int tmp = answer[i];
                answer[i] = answer[max];
                answer[max] = tmp;
            }
            sb.append(answer[i]);
        }

        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();

        int[] answer = new int[N.length()];
        for (int i = 0; i < N.length(); i++) {
            answer[i] = Integer.valueOf(N.charAt(i) - 48);
        }

        System.out.println(solution(answer));
    }
}