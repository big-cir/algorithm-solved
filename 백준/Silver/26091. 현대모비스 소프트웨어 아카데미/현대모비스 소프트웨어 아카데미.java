import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(arr);
        
        if (N == 1) {
            System.out.println(0);
            return;
        }

        int lt = 0;
        int rt = N - 1;
        int answer = 0;
        while (lt < rt) {
            if (arr[lt] + arr[rt] >= K) {
                lt++;
                rt--;
                answer++;
            } else {
                lt++;
            }
        }

        System.out.println(answer);
    }
}