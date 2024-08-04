import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int a = info[0];
        int b = info[1];
        int max = 100001;
        int[] dp = new int[max];

        // way 1
        System.out.println(bfs(a, b, max, dp));

        // way 2
        System.out.println(bfs(a, b));
      
    }

    private static int bfs(int a, int b, int max, int[] dp) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(a);

        while (!queue.isEmpty()) {
            int now = queue.poll();

            if (now == b) {
                return dp[now];
            }

            int multiValue = now * 2;
            if (multiValue < max && dp[multiValue] == 0) {
                queue.offer(multiValue);
                dp[multiValue] = dp[now];
            }

            int addValue = now + 1;
            if (addValue < max && dp[addValue] == 0) {
                queue.offer(addValue);
                dp[addValue] = dp[now] + 1;
            }

            int minusValue = now - 1;
            if (minusValue >= 0 && dp[minusValue] == 0) {
                queue.offer(minusValue);
                dp[minusValue] = dp[now] + 1;
            }

        }

        return 0;
    }

    private static int bfs(int a, int b) {
          if (a >= b) return a - b; 
          
          int max = 100001;
          Queue<int[]> queue = new LinkedList<>();
          Set<Integer> set = new HashSet<>();
          queue.offer(new int[] {a, 0});
          set.add(a);
  
          while (!queue.isEmpty()) {
              int[] now = queue.poll();
  
              if (now[0] == b) {
                  return now[1];
              }
  
              int multiValue = now[0] * 2;
              if (multiValue < max && !set.contains(multiValue)) {
                  queue.offer(new int[] {multiValue, now[1]});
                  set.add(multiValue);
              }
  
              int addValue = now[0] + 1;
              if (addValue < max && !set.contains(addValue)) {
                  queue.offer(new int[] {addValue, now[1] + 1});
                  set.add(addValue);
              }
  
              int minusValue = now[0] - 1;
              if (minusValue > 0 && !set.contains(minusValue)) {
                  queue.offer(new int[] {minusValue, now[1] + 1});
                  set.add(minusValue);
              }
          }
  
          return 0;
      }
}

