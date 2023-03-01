import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void solution(int x, PriorityQueue<Integer> pq) {
        if (x != 0) {
            pq.add(x);
        } else {
            if (pq.isEmpty()) {
                sb.append(0).append("\n");
            } else {
                int p_val = pq.poll();
                pq.remove(0);
                sb.append(p_val).append("\n");
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // ArrayList<Integer> list = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(((o1, o2) -> {
            if (Math.abs(o1) == Math.abs(o2)) {
                return o1 > o2 ? 1 : -1;
            } else {
                return Math.abs(o1) - Math.abs(o2);
            }
        }));
        for (int i = 0; i < N; i++) {
            // solution(Integer.parseInt(br.readLine()), list);
            solution(Integer.parseInt(br.readLine()), pq);
        }

        System.out.println(sb);
    }
}
