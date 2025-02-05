import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(st.nextToken());
            arr[i] = value;
        }

        if (N == 1) {
            System.out.println(1);
            return;
        }

        Map<Integer, Integer> map = new HashMap<>();
        int p1 = 0;
        int p2 = 0;
        int answer = 0;
        while (p2 < N) {
            map.put(arr[p2], map.getOrDefault(arr[p2], 0) + 1);
            p2++;

            if (map.size() <= 2) {
                answer = Math.max(answer, p2 - p1);
            } else {
                map.replace(arr[p1], map.get(arr[p1]) - 1);
                if (map.get(arr[p1]) == 0) map.remove(arr[p1]);
                p1++;
            }
        }

        System.out.println(answer);
    }
}
