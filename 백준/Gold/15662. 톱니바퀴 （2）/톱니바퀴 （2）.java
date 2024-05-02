import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < T; i++) {
            List<Integer> tmp = new ArrayList<>();
            if (i == 0) {
                tmp.add(i + 1);
            } else if (i < T - 1) {
                tmp.add(i - 1);
                tmp.add(i + 1);
            } else {
                tmp.add(i - 1);
            }
            graph.add(tmp);
        }

        List<LinkedList<Integer>> list = new ArrayList<>();
        for (int i = 0; i < T; i++) {
            LinkedList<Integer> ll = new LinkedList<>();
            for (int x : Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray()) {
                ll.addLast(x);
            }
            list.add(ll);
        }

        // 맞닿는 부분 idx = 2, 6
        // 맞닿는 부분의 극이 다르면 반시계 회전
        // 맞닿는 부분의 극이 같으면 회전 X
        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            int[] info = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            int[] ch = new int[T];
            Queue<int[]> queue = new LinkedList<>();
            ch[info[0] - 1] = 1;
            queue.offer(new int[] {info[0] - 1, info[1]});

            while (!queue.isEmpty()) {
                int[] curInfo = queue.poll();
                int idx = curInfo[0];
                int dir = curInfo[1];

                for (int next : graph.get(idx)) {
                    if (ch[next] == 0) {
                        ch[next] = 1;

                        if (next == idx - 1 && list.get(idx).get(6) != list.get(next).get(2)) {
                            if (dir == -1) {
                                queue.offer(new int[] {next, 1});
                            } else {
                                queue.offer(new int[] {next, -1});
                            }
                        } else if (next == idx + 1 && list.get(idx).get(2) != list.get(next).get(6)) {
                            if (dir == -1) {
                                queue.offer(new int[] {next, 1});
                            } else {
                                queue.offer(new int[] {next, -1});
                            }
                        }
                    }
                }

                LinkedList<Integer> tmp = list.get(idx);
                if (dir == 1) {
                    tmp.addFirst(tmp.removeLast());
                } else {
                    tmp.addLast(tmp.removeFirst());
                }
            }
        }

        int answer = 0;
        for (LinkedList<Integer> x : list) {
            if (x.get(0) == 1) answer++;
        }
        System.out.println(answer);
    }
}
