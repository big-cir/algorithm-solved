import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Deque<int[]> stack = new ArrayDeque<>();

        int[] answer = new int[N];
        for (int i = N - 1; i >= 0; i--) {
            if (stack.isEmpty()) {
                stack.push(new int[] {i, arr[i]});
            } else if (stack.peek()[1] < arr[i]) {
                while (!stack.isEmpty() && stack.peek()[1] < arr[i]) {
                    answer[stack.pop()[0]] = i + 1;
                }
                stack.push(new int[] {i, arr[i]});
            } else {
                stack.push(new int[] {i, arr[i]});
            }
        }

        for (int i = 0; i < N; i++) {
            System.out.print(answer[i] + " ");
        }
    }
}