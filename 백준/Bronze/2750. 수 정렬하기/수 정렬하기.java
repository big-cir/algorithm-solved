import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// BOJ_2750_수정렬하기
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            A[i] = num;
        }
        Arrays.sort(A);
        
        for (int i = 0; i < A.length; i++) {
            System.out.println(A[i]);
        }
    }
}
