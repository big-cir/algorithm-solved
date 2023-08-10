import java.io.*;
import java.util.*;

public class Main {
   
    public static long chVal(long sum) {
        return Math.abs(sum);
    }

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] answer = new long[3];
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        long min = Long.MAX_VALUE;
		
        for (int i = 0; i < N - 2; i++) {
            int lt = i + 1;
            int rt = N - 1;
            
            while (lt < rt) {
                long sum = (long)arr[i] + arr[lt] + arr[rt];
                long tmp = chVal(sum);
                if (tmp < min) {
                    min = tmp;
                    answer[0] = arr[i];
                    answer[1] = arr[lt];
                    answer[2] = arr[rt];
                }
                if (sum > 0) {
                    rt--;
                } else {
                    lt++;
                }
            }
        }
        
		for (long x : answer) {
            System.out.print(x + " ");
        }
	}
}