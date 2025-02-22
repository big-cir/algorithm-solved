import java.io.*;
import java.util.*;

public class Main {

    static class Task implements Comparable<Task> {
        int d;
        int t;

        public Task(int d, int t) {
            this.d = d;
            this.t = t;
        }

        @Override
        public int compareTo(Task o) {
            if (this.t == o.t) {
                return o.d - this.d;
            }

            return o.t - this.t;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        List<Task> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            list.add(new Task(d, t));
        }
        Collections.sort(list);
        
        int last = list.get(0).t - list.get(0).d;
        for (int i = 1; i < N; i++) {
            Task task = list.get(i);
            if (task.t <= last) {
                last = task.t - task.d;
            } else {
                last -= task.d;
            }
        }
        
        System.out.println(last);
    }
}