import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, total;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        total = Integer.parseInt(st.nextToken());

        map = new int[N][2];
        for (int i = 0; i < N; i++) {
            map[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        Arrays.sort(map, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int sum1 = o1[0] + o1[1];
                int sum2 = o2[0] + o2[1];

                if (sum1 == sum2) {
                    return o1[0] - o2[0];
                }

                return sum1 - sum2;
            }
        });

        int sum = 0;
        int answer = 0;
        for (int i = 0; i < N; i++) {
            int[] giftInfo = map[i];

            sum += giftInfo[0] + giftInfo[1];
            if (sum > total) {
                sum -= giftInfo[0] / 2;
            } 

            if (sum <= total) answer++;
            else break;
        }

        System.out.println(answer);
    }
}
