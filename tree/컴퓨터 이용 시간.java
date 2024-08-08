import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Integer> startList = new ArrayList<>();
        List<int[]> points = new ArrayList<>();
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            startList.add(start);
            points.add(new int[] {start, 1, i, 0});
            points.add(new int[] {end, -1, i, 0});
        }

        Collections.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        Queue<Integer> pq = new PriorityQueue<>();
        for (int i = 1; i <= N; i++) pq.offer(i);

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < points.size(); i++) {
            int[] now = points.get(i);

            if (now[1] == 1) {
                int cNum = pq.poll();
                map.put(now[2], cNum);
                now[3] = cNum;
            }

            if (now[1] == -1) {
                pq.offer(map.get(now[2]));
            }
        }

        Collections.sort(points, (a, b) -> a[2] - b[2]);

        for (int i = 0; i < points.size(); i++) {
            int[] now = points.get(i);

            if (now[1] == 1) {
                System.out.print(now[3] + " ");
            }
        }
    }
}
