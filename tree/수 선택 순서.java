import java.util.*;
import java.io.*;

public class Main {

    static class Pos {
        int value;
        int idx;

        public Pos(int value, int idx) {
            this.value = value;
            this.idx = idx;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int maxIdx = N - 1;
        Queue<Pos> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            queue.offer(new Pos(arr[i], i));
        }
        Arrays.sort(arr);
        int max = arr[maxIdx];

        int answer = 1;
        while (true) {
            Pos now = queue.poll();
            int value = now.value;
            int idx = now.idx;

            if (value == max) {
                if (idx == X) {
                    break;
                }

                maxIdx--;
                max = arr[maxIdx];
                answer++;
                queue.offer(now);
            } else {
                queue.offer(now);
            }
        }

        System.out.println(answer);
    }
}
