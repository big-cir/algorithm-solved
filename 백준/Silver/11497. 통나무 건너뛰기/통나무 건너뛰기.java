import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            int N = Integer.parseInt(br.readLine());
            int[] hegiht = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                hegiht[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(hegiht);

            Deque<Integer> deque = new ArrayDeque<>();
            if (N % 2 == 1) {
                deque.offer(hegiht[N - 1]);
                for (int i = N - 2; i >= 0; i--) {
                    if (i % 2 == 1) deque.addLast(hegiht[i]);
                    else deque.addFirst(hegiht[i]);
                }
            } else {
                for (int i = N - 1; i >= 1; i -= 2) {
                    deque.addFirst(hegiht[i]);
                    deque.addLast(hegiht[i - 1]);
                }
            }

            int answer = 0;
            // 10 11 12 13 12 11 10
            for (int i = 0; i < N - 1; i++) {
                int last = deque.getLast();
                int nowVal = deque.poll();
                int nextVal = deque.peek();
                answer = Math.max(answer, Math.max(Math.abs(nowVal - last), Math.abs(nowVal - nextVal)));

                deque.addLast(nowVal);
            }
            System.out.println(answer);
        }
    }
}
