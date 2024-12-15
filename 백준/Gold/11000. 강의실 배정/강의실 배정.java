import java.io.*;
import java.util.*;

public class Main {

    static int N;

    static class Room implements Comparable<Room> {
        private int start;
        private int end;

        public Room(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Room r) {
            if (this.start == r.start) return this.end - r.end;
            return this.start - r.start;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        Queue<Room> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            pq.offer(new Room(start, end));
        }

        Queue<Integer> use = new PriorityQueue<>();
        int answer = 0;
        while (!pq.isEmpty()) {
            Room now = pq.poll();

            if (!use.isEmpty() && now.start >= use.peek()) {
                use.poll();
            }

            use.offer(now.end);
            answer = Math.max(answer, use.size());
        }

        System.out.println(answer);
    }
}