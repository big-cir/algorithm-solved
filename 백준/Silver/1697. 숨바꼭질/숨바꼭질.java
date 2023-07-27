import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, K, answer = 0, size = 100001;
    static int[] dis;

    public static void BFS(int N) {
        dis[N] = 1;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);

        while (!queue.isEmpty()) {
            int curIdx = queue.poll();
            if (curIdx == K) {
                answer = dis[curIdx] - 1;
                return;
            }

            if (curIdx == 0) {
                if (dis[curIdx + 1] == 0) {
                    dis[curIdx + 1] = dis[curIdx] + 1; // 걷기
                    dis[curIdx * 2] = dis[curIdx] + 1;
                    queue.offer(curIdx + 1);
                }
            }

            if (curIdx > 0 && dis[curIdx - 1] == 0) {
                dis[curIdx - 1] = dis[curIdx] + 1;
                queue.offer(curIdx - 1);
            }

            if (curIdx < size - 1 && dis[curIdx + 1] == 0) {
                dis[curIdx + 1] = dis[curIdx] + 1;
                queue.offer(curIdx + 1);
            }

            if (curIdx * 2 < size && dis[curIdx * 2] == 0) {
                dis[curIdx * 2] = dis[curIdx] + 1;
                queue.offer(curIdx * 2);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        dis = new int[size];
        BFS(N);

        System.out.println(answer);
    }
}