import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int answer = 0;
        for (int i = 0; i < N; i++) {
            int val = arr[i], sum = 0;
            int lt = 0, rt = N - 1;

            while (lt < rt) {
                sum = arr[lt] + arr[rt];
                if (sum == val) {
                    if (lt == i) lt++;
                    else if (rt == i) rt--;
                    else {
                        answer++;
                        break;
                    }
                }

                if (sum > val) {
                    rt--;
                }

                if (sum < val) {
                    lt++;
                }

            }
        }
        System.out.println(answer);
    }
}
