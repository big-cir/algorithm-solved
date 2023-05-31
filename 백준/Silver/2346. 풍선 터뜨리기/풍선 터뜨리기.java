import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static class Balloon {
        private int num;
        private int move;

        public Balloon(int num, int move) {
            this.num = num;
            this.move = move;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        Deque<Balloon> que = new ArrayDeque<>();

        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) {
            int move = Integer.parseInt(st.nextToken());
            que.add(new Balloon(i, move));
        }

        while(!que.isEmpty()) {
            sb.append(que.getFirst().num + " ");
            int next = que.poll().move;
            if(que.isEmpty()) break;

            if(next > 0) {
                next -= 1;
                for(int i = 0; i < next; i++) {
                    que.addLast(que.pollFirst());
                }
            }else {
                for(int i = 0; i < Math.abs(next); i++) {
                    que.addFirst(que.pollLast());
                }
            }
        }
        System.out.println(sb.toString());
    }
}