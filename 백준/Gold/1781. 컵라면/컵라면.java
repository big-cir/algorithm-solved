import java.io.*;
import java.util.*;

public class Main {

    static int N;

    static class Problem implements Comparable<Problem> {
        int deadLine;
        int cupCount;

        public Problem(int deadLine, int cupCount) {
            this.deadLine = deadLine;
            this.cupCount = cupCount;
        }

        @Override
        public int compareTo(Problem p) {
            if (this.deadLine == p.deadLine) {
                return p.cupCount - this.cupCount;
            }

            return p.deadLine - this.deadLine;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        Queue<Problem> pq = new PriorityQueue<>();
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int deadLine = Integer.parseInt(st.nextToken());
            int cupCount = Integer.parseInt(st.nextToken());

            Problem problem = new Problem(deadLine, cupCount);
            pq.offer(problem);
        }

        int time = N;
        Queue<Problem> compQueue = new PriorityQueue<>(new Comparator<Problem>() {
            @Override
            public int compare(Problem o1, Problem o2) {
                return o2.cupCount - o1.cupCount;
            }
        });

        long answer = 0L;
        while (time > 0) {
            while (!pq.isEmpty()) {
                Problem now = pq.poll();
                if (time <= now.deadLine) {
                    compQueue.add(now);
                } else {
                    pq.offer(now);
                    break;
                }
            }

            if (!compQueue.isEmpty()) answer += compQueue.poll().cupCount;
            time--;
        }

        System.out.println(answer);
    }
}