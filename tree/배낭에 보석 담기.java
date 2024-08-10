import java.io.*;
import java.util.*;

public class Main {

    static class Boseok implements Comparable<Boseok> {
        int w;
        int cost;

        public Boseok(int w, int cost) {
            this.w = w;
            this.cost = cost;
        }

        @Override
        public int compareTo(Boseok o) {
            return Double.compare((double)o.cost / o.w, (double)this.cost / this.w);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());  // 보석
        int M = Integer.parseInt(st.nextToken());  // 가방 무게

        PriorityQueue<Boseok> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            pq.offer(new Boseok(w, cost));
        }

        int remainW = M;
        double answer = 0.0;
        while (!pq.isEmpty() && remainW > 0) {
            Boseok now = pq.poll();

            if (remainW >= now.w) {
                remainW -= now.w;
                answer += now.cost;
            } else {
                answer += (double)now.cost * remainW / now.w;
                break;
            }
        }
        
        System.out.printf("%.3f\n", answer);
    }
}
