import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
    static int K;
    static long[] files;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for (int i = 0; i < tc; i++) {
            K = Integer.parseInt(br.readLine());
            files = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
            System.out.println(solution());
        }
    }

    private static long solution() {
        long sum = 0;
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (long x : files) {
            pq.add(x);
        }

        while (pq.size() > 1) {
            long tmp = pq.poll() + pq.poll();
            sum += tmp;
            pq.add(tmp);
        }
        return sum;
    }
}