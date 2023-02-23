import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] A = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(N, M, A));
    }

    private static int solution(int N, int M, int[] A) {
        int answer = 0;
        int lt = Arrays.stream(A).max().getAsInt();
        int rt = Arrays.stream(A).sum();

        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if (count(A, mid) <= M) {
                answer = mid;
                rt = mid - 1;
            } else {
                lt = mid + 1;
            }
        }

        return answer;
    }

    private static int count(int[] A, int capacity) {
        int cnt = 1;  
        int sum = 0;   
        for (int x : A) {
            if (sum + x > capacity) { 
                cnt++;
                sum = x;
            } else {
                sum += x;
            }
        }
        return cnt;
    }
}