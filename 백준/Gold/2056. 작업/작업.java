import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] indegree = new int[N + 1];
        int[] workTime = new int[N + 1];
        StringTokenizer st;
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i <= N; i++) list.add(new ArrayList<>());

        for (int i = 1; i <= N; i++) {
            int workNum = i;
            st = new StringTokenizer(br.readLine());

            int time = Integer.parseInt(st.nextToken());
            workTime[workNum] = time;
            int preCount = Integer.parseInt(st.nextToken());
            for (int j = 0; j < preCount; j++) {
                int preWork = Integer.parseInt(st.nextToken());
                indegree[workNum]++;
                list.get(preWork).add(workNum);
            }
        }
        
        int[] result = new int[N + 1];
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            result[i] = workTime[i];
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int next : list.get(now)) {
                indegree[next]--;
                result[next] = Math.max(result[next], result[now] + workTime[next]);

                if (indegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        System.out.println(Arrays.stream(result).max().getAsInt());
    }
}