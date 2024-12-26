import java.io.*;
import java.util.*;

public class Main {

    static class Tower {
        double x;
        double y;
        int count;

        public Tower(double x, double y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        double R = Double.parseDouble(st.nextToken());
        double D = Double.parseDouble(st.nextToken());
        double X = Double.parseDouble(st.nextToken());
        double Y = Double.parseDouble(st.nextToken());

        List<double[]> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());
            list.add(new double[] {x, y, D});
        }

        Queue<Tower> queue = new LinkedList<>();
        queue.offer(new Tower(X, Y, 0));
        boolean[] visit = new boolean[N];
        double answer = 0;
        while (!queue.isEmpty()) {
            Tower now = queue.poll();

            for (int i = 0; i < N; i++) {
                if (visit[i]) continue;
                double[] next = list.get(i);
                double distance = Math.sqrt(
                        Math.pow(now.x - next[0], 2) +
                        Math.pow(now.y - next[1], 2)
                );
                
                if (distance <= R) {
                    if (now.count == 0) {
                        answer += D;
                    } else {
                        answer += (D / Math.pow(2, now.count));
                    }
                    
                    queue.offer(new Tower(next[0], next[1], now.count + 1));
                    visit[i] = true;
                }
            }
        }

        System.out.println(answer);
    }
}