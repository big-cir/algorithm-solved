import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        Queue<Integer> plus = new PriorityQueue<>((x, y) -> y - x);
        Queue<Integer> minus = new PriorityQueue<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(st.nextToken());
            if (value > 0) plus.add(value);
            else minus.add(value);
        }

        int answer = 0;
        int max = 0;
        while (!plus.isEmpty()) {
            for (int i = 0; i < M; i++) {
                if (plus.isEmpty()) continue;
                int current = plus.poll();
                if (i == 0) {
                    answer +=  2 * current;
                    if (current > max) {
                        max = current;
                    }
                }
            }
        }

        while (!minus.isEmpty()) {
            for (int i = 0; i < M; i++) {
                if (minus.isEmpty()) continue;

                int current = minus.poll();
                if (i == 0) {
                    answer += 2 * Math.abs(current);
                    if (Math.abs(current) > max) {
                        max = Math.abs(current);
                    }
                }
            }
        }
        answer -= max;
        System.out.println(answer);
    }
}
