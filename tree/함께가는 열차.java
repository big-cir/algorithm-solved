import java.util.*;
import java.io.*;

public class Main {

    static class Train implements Comparable<Train> {
        int pos;
        int speed;

        public Train(int pos, int speed) {
            this.pos = pos;
            this.speed = speed;
        }

        @Override
        public int compareTo(Train t) {
            return this.pos - t.pos;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Train> list = new ArrayList<>();

        if (N == 1) {
            System.out.println(1);
            return;
        }

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int pos = Integer.parseInt(st.nextToken());
            int speed = Integer.parseInt(st.nextToken());
            list.add(new Train(pos, speed));
        }
        Collections.sort(list);

        Train last = list.get(N - 1);
        int front = last.speed;
        int answer = 1;
        for (int i = N - 2; i >= 0; i--) {
            Train next = list.get(i);
            int pos = next.pos;
            int speed = next.speed;
            
            if (front >= speed) {
                answer++;
                front = speed;
            } 
        }

        System.out.println(answer);
    }
}
