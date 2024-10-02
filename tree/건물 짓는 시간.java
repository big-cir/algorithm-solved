import java.util.*;
import java.io.*;

public class Main {
    
    static int N;
    static List<List<Integer>> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        for (int i = 0; i <= N; i++) list.add(new ArrayList<>());
        int[] indegree = new int[N + 1];
        int[] times = new int[N + 1];

        StringTokenizer st;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            List<Integer> tmp = list.get(i);
            times[i] = time;

            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());
                indegree[num]++;
                tmp.add(num);
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        int[] candidate = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
                candidate[i] = times[i];
            }
        }

        while (!queue.isEmpty()) {
            int now = queue.poll();
            
            for (int next : list.get(now)) {
                indegree[next]--;
                candidate[next] = Math.max(candidate[next], times[next] + candidate[now]);

                if (indegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        System.out.println(Arrays.stream(candidate).max().getAsInt());
    }
}
