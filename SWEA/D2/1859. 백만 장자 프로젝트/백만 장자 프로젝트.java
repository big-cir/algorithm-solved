import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for (int i = 0; i < tc; i++) {
            int N = Integer.parseInt(br.readLine());

            Queue<Integer> queue = new LinkedList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                queue.offer(Integer.parseInt(st.nextToken()));
            }
            System.out.println("#" + (i + 1) + " " + solution(queue, N));
        }
    }

    private static long solution(Queue<Integer> queue, int N) {
        long answer = 0;
        int max = Collections.max(queue);

        Queue<Integer> save = new LinkedList<>();
        while (!queue.isEmpty()) {
            int value = queue.poll();

            if (max == value) {
                while (!save.isEmpty()) {
                    answer += (max - save.poll());
                }

                if (!queue.isEmpty()) {
                    max = Collections.max(queue);
                }
            } else {
                save.add(value);
            }
        }
        return answer;
    }
}