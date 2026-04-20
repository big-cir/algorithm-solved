class Solution {
    public String removeStars(String s) {
        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (ch == '*') {
                int length = sb.length();
                if (length - 1 >= 0) {
                    sb.deleteCharAt(length - 1);
                }
            } else {
                sb.append(ch);
            }
        }

        return sb.toString();
    }
}

// stack
class Solution {
    public String removeStars(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (ch == '*') {
                if (!stack.isEmpty()) stack.pop();
            } else {
                stack.push(ch);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }
}
