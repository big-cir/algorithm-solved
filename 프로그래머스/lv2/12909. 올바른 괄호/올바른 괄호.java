import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();

        for (char x : chars) {
            if (x == '(') stack.push('(');
            else {
                if (stack.isEmpty() && x == ')') {
                    answer = false;
                    break;
                } else {
                    stack.pop();
                }
            }
        }
        if (!stack.isEmpty()) answer = false;
        
        return answer;
    }
}