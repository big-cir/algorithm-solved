import java.io.*;
import java.util.*;

public class Main {

    static int tc, N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        tc = Integer.parseInt(br.readLine());
        for (int i = 0; i < tc; i++) {
            N = Integer.parseInt(br.readLine());
            StringTokenizer st;

            List<int[]> list = new ArrayList<>();
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                int s1 = Integer.parseInt(st.nextToken());
                int s2 = Integer.parseInt(st.nextToken());
                list.add(new int[] {s1, s2});
            }

            Collections.sort(list, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0] - o2[0];
                }
            });

            int answer = 1;
            int min = list.get(0)[1];
            for (int j = 1; j < N; j++) {
                int[] h = list.get(j);

                if (min > h[1]) {
                    min = h[1];
                    answer++;
                }
            }

            System.out.println(answer);
        }

    }
}