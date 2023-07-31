import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, S;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int answer = Integer.MAX_VALUE;
        
        int lt = 0, rt = 0;
        int sum = arr[0];
        while (lt < N && rt < N) {
            if (sum >= S) {
                answer = Math.min(rt - lt + 1, answer);
                sum -= arr[lt];
                lt++;
            } else {
                rt++;
                if (rt < N) {
                    sum += arr[rt];
                }
            }
        }
        
        if (answer == Integer.MAX_VALUE) answer = 0;
        System.out.println(answer);
    }
}