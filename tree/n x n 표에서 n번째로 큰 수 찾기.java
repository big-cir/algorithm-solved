import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Info implements Comparable<Info> {
        int i;
        int j;
        int value;

        public Info(int i, int j, int value) {
            this.i = i;
            this.j = j;
            this.value = value;
        }

        @Override
        public int compareTo(Info o) {
            return o.value - this.value;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        Queue<Info> pq = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            pq.offer(new Info(i, 1, arr[i]));
        }

        int cnt = 0;
        while (cnt < N - 1) {
            Info now = pq.poll();
            int j = now.j;
            j++;

            pq.offer(new Info(now.i, j, arr[now.i] / j));
            cnt++;
        }
        
        System.out.println(pq.poll().value);
    }
}
