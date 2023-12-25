import java.util.Map;
import java.util.HashMap;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < answer.length; i++) {
            if (!map.containsKey(toStr(s.charAt(i)))) {
                map.put(toStr(s.charAt(i)), i);
                answer[i] = -1;
            } else {
                answer[i] = i - map.get(toStr(s.charAt(i)));
                map.replace(toStr(s.charAt(i)), i);
            }
        }
        return answer;
    }
    
    private String toStr(char ch) {
        return String.valueOf(ch);
    }
}