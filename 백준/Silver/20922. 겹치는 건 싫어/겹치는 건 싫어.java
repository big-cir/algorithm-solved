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
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(st.nextToken());
            arr[i] = value;
        }

        int lt = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int answer = 0;
        for (int rt = 0; rt < N; rt++) {
            int current = arr[rt];
            map.put(current, map.getOrDefault(current, 0) + 1);

            while (map.get(arr[rt]) > K) {
                map.put(arr[lt], map.get(arr[lt]) - 1);
                lt++;
            }

            answer = Math.max(answer, rt - lt + 1);
        }

        System.out.println(answer);
    }
}