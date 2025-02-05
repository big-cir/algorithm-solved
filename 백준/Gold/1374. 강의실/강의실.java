import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
            if (this.start == r.start) return this.end - r.end;
            return this.start - r.start;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Queue<Room> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            int[] info = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            pq.offer(new Room(info[1], info[2]));
        }

        int answer = 0;
        Queue<Integer> available = new PriorityQueue<>();
        while (!pq.isEmpty()) {
            Room now = pq.poll();
            if (!available.isEmpty() && available.peek() <= now.start) {
                available.poll();
            }

            available.offer(now.end);
            answer = Math.max(answer, available.size());
        }

        System.out.println(answer);
    }
}
