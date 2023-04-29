import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int N, S, answer;
    public static int[] arr, ch;

    public static void solution(int Level, int sum, int startIdx) {
        if (Level >= 1 && Level <= N) {
            if (sum == S) {
                answer++;
            }
        }

        for (int i = startIdx; i < N; i++) {
            if (ch[i] == 0) {
                ch[i] = 1;
                solution(Level + 1, sum + arr[i], i + 1);
                ch[i] = 0;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        arr = new int[N];
        ch = new int[N];
        answer = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        solution(0, 0, 0);
        System.out.println(answer);
    }
}