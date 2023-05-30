import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static class Priority {
        private int idx;
        private int priority;

        public Priority(int idx, int priority) {
            this.idx = idx;
            this.priority = priority;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for (int i = 0; i < tc; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 문서 갯수
            int M = Integer.parseInt(st.nextToken());   // queue 의 위치

            List<Priority> list = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                Priority priority = new Priority(j, Integer.parseInt(st.nextToken()));
                list.add(priority);
            }

            int idx = 0;
            int answer = 0;
            while (!list.isEmpty()) {
                int p = list.get(0).priority;

                for (int j = 0; j < list.size(); j++) {
                    if (list.get(j).priority > p) {
                        p = list.get(j).priority;
                        list.add(list.get(0));
                        list.remove(0);
                        break;
                    }

                    if (j == list.size() - 1) {
                        idx++;
                        Priority remove = list.remove(0);
                        if (remove.idx == M) {
                            answer = idx;
                        }
                    }
                }
            }

            System.out.println(answer);
        }
    }
}