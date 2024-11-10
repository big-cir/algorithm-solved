import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[] result;
    static List<Ball> list;

    static class Ball implements Comparable<Ball> {
        private int pos;
        private int color;
        private int size;

        public Ball(int pos, int color, int size) {
            this.pos = pos;
            this.color = color;
            this.size = size;
        }

        @Override
        public int compareTo(Ball o) {
            if (this.size == o.size) return this.color - o.color;
            return this.size - o.size;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        result = new int[N];

        list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int[] info = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int color = info[0];
            int size = info[1];

            Ball ball = new Ball(i, color, size);
            list.add(ball);
        }
        Collections.sort(list);

        int[] posSums = new int[N + 1];
        int sum = 0;
        int pSize = 0;
        int cnt = 0;
        Ball prev = null;

        int[] result = new int[N];
        for (Ball ball : list) {
            int curSize = ball.size;
            result[ball.pos] = sum - posSums[ball.color];
            
            if (pSize == curSize) {
                if (prev != null && ball.color == prev.color) result[ball.pos] = result[prev.pos];
                else result[ball.pos] -= (cnt * pSize);
                cnt++;
            } else {
                cnt = 1;
                pSize = curSize;
            }

            prev = ball;
            posSums[ball.color] += curSize;
            sum += curSize;
        }

        for (int re : result) {
            System.out.println(re);
        }
    }
}