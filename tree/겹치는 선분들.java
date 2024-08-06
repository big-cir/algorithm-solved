import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int start = 0;
        List<int[]> points = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int length = Integer.parseInt(st.nextToken());
            String dir = st.nextToken();

            if ("R".equals(dir)) {
                points.add(new int[] {start, 1});
                start += length;

                int end = start;
                points.add(new int[] {end, -1});
            } else {
                // end 를 반대로
                int end = start;
                points.add(new int[] {end, -1});

                start -= length;
                points.add(new int[] {start, 1});
            }
        }

        Collections.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) {
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }
        });

        int sum = 0;
        int answer = 0;
        for (int i = 0; i < points.size(); i++) {
            int[] point = points.get(i);

            if (sum >= K) {
                int prev = points.get(i - 1)[0];
                answer += point[0] - prev;
            }

            sum += point[1];
        }

        System.out.println(answer);
    }
}
