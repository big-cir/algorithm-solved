import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= tc; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int[] pockets = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            Arrays.sort(pockets);
            
            int answer = Integer.MAX_VALUE;
            for (int j = 0; j < N - K + 1; j++) {
                int diff = pockets[K - 1 + j] - pockets[j];
                answer = Math.min(diff, answer);
            }

            sb.append("#").append(i).append(" ").append(answer).append("\n");
        }
        
        System.out.println(sb.deleteCharAt(sb.length() - 1));
    }
}
