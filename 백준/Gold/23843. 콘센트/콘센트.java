import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Integer[] arr2 = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(arr2, Comparator.reverseOrder());

        // <1> <1 1 1 1> <1 1 1 1>
        // <1> <1 1 1 1 1 1 1 1>
        Queue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < arr2.length; i++) {
            if (pq.size() < M) {
                pq.offer(arr2[i]);
            } else {
                int t = pq.poll();
                pq.offer(t + arr2[i]);
            }
        }
        
        System.out.println(pq.stream().mapToInt(val -> val).max().getAsInt());
    }
}