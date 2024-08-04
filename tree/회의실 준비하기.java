import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Time implements Comparable<Time> {
        private int start;
        private int end;

        public Time(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Time o) {
            if (end == o.end) return start - o.start;
            return end - o.end;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Queue<Time> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            int[] info = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            pq.offer(new Time(info[0], info[1]));
        }

        int cnt = 0;
        int endTime= 0;
        while (!pq.isEmpty()) {
            Time now = pq.poll();

            if (now.start >= endTime) {
                cnt++;
                endTime = now.end;
            }
        }

        System.out.println(cnt);
    }
}
