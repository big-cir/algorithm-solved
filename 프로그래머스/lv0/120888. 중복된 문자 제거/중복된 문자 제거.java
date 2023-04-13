import java.util.*;
class Solution {
    public String solution(String my_string) {
        String answer = "";
        Set<Character> set = new HashSet<>();
        char[] chars = my_string.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (set.contains(chars[i])) {
                continue;
            }
            set.add(chars[i]);
            answer += chars[i];
        }
        return answer;
    }
}