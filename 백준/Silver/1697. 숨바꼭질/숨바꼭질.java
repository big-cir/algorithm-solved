import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int ran = 100001;
    static int N, K, answer;
    static int[] dis = new int[ran];

    public static void BFS(int N) {
        dis[N] = 1;                 // 수빈이의 위치
        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);

        while (!queue.isEmpty()) {
            // 현재 인덱스
            int cur = queue.poll();

            // index 가 17이면 동생에게 도착. 시간 출력
            if (cur == K) {
                answer = dis[cur] - 1;
                return;
            }

            if (cur == 0) {
                if (dis[cur + 1] == 0) {
                    dis[cur + 1] = dis[cur] + 1;
                    dis[cur * 2] = dis[cur] + 1;
                    queue.offer(cur + 1);
                }
            }

            // 걷기 X - 1
            if (cur > 0 && dis[cur - 1] == 0) {
                dis[cur - 1] = dis[cur] + 1;
                queue.offer(cur - 1);
            }

            // 걷기 X + 1
            if (cur < ran - 1 && dis[cur + 1] == 0) {
                dis[cur + 1] = dis[cur] + 1;
                queue.offer(cur + 1);
            }

            // 순간이동 X * 2
            if (cur * 2 < ran && dis[cur * 2] == 0  ) {
                dis[cur * 2] = dis[cur] + 1;
                queue.offer(cur * 2);
            }


        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        BFS(N);
        System.out.println(answer);
    }
}