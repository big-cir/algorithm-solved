import java.util.ArrayDeque;
import java.util.Deque;
class Solution
{
    public int solution(String s)
    {
        int answer = 0;
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty()) stack.push(s.charAt(i));
            else if (stack.peek() == s.charAt(i)) {
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }

        if (stack.isEmpty()) answer = 1;
        return answer;
    }
}