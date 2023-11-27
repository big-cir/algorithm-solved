import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static int N, answer;
    static List<Integer>[] list;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;

        list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int point = Integer.parseInt(st.nextToken());
            int color = Integer.parseInt(st.nextToken());

            list[color].add(point);
        }

        answer = 0;
        for (int i = 1; i <= N; i++) {
            List<Integer> now = list[i];
            Collections.sort(now);

            int distance = 0;
            for (int j = 0; j < now.size(); j++) {
                if (j == 0) {
                    distance += now.get(j + 1) - now.get(j);
                    continue;
                }

                if (j == (now.size() - 1)) {
                    distance += (now.get(j) - now.get(j - 1));
                    continue;
                }

                distance += Math.min(getLeft(j, now), getRight(j, now));
            }
            answer += distance;
        }
        System.out.println(answer);
    }

    private static int getLeft(int idx, List<Integer> now) {
        return Math.abs(now.get(idx) - now.get(idx - 1));
    }

    private static int getRight(int idx, List<Integer> now) {
        return Math.abs(now.get(idx) - now.get(idx + 1));
    }
}
