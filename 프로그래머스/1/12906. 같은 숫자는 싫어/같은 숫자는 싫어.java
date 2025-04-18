import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int x : arr) {
            if (stack.isEmpty()) {
                stack.push(x);
            } else {
                if (stack.peek() == x) continue;
                else stack.push(x);
            }
        }
        
        int size = stack.size();
        int[] answer = new int[size];
        for (int i = size - 1; i >= 0; i--) answer[i] = stack.pop();
        return answer;
    }
}