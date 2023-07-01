import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        
        for (char x : chars) {
            if (!stack.isEmpty()) {
                Character ch = stack.peek();
                if (x == ch) {
                    stack.pop();
                    continue;
                }
            }
            stack.push(x);
        }
        
        if (stack.isEmpty()) answer = 1;
        return answer;
    }
}