import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static List<List<Integer>> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        for (int i = 0; i < N; i++) list.add(new ArrayList<>());

        int[] info = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int root = 0;
        for (int i = 0; i < N; i++) {
            if (info[i] == -1) root = i;
        }

        for (int i = 0; i < N; i++) {
            if (i == root) continue;

            int v1 = info[i];
            int v2 = i;

            list.get(v1).add(v2);
        }

        int rmVertex = Integer.parseInt(br.readLine());
        if (info[rmVertex] == -1) {
            System.out.println(0);
            return;
        }

        list.get(info[rmVertex]).remove(Integer.valueOf(rmVertex));
        list.get(rmVertex).clear();

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(root);

        int answer = 0;
        while (!queue.isEmpty()) {
            int now = queue.poll();

            if (now == rmVertex) continue;
            if (list.get(now).size() == 0) {
                answer++;
            }

            for (int next : list.get(now)) {
                queue.offer(next);
            }
        }

        System.out.println(answer);
    }
}
