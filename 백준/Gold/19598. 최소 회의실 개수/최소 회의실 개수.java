import java.io.*;
import java.util.*;

public class Main {

    static class Room implements Comparable<Room> {
        int start;
        int end;

        public Room(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Room r) {
            if (this.start == r.start) {
                return this.end - r.end;
            }
            return this.start - r.start;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Queue<Room> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            int[] info = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            pq.offer(new Room(info[0], info[1]));
        }

        Queue<Integer> available = new PriorityQueue<>();
        while (!pq.isEmpty()) {
            Room now = pq.poll();

            if (!available.isEmpty()) {
                if (available.peek() <= now.start) available.poll();
            }

            available.offer(now.end);
        }

        System.out.println(available.size());
    }
}
