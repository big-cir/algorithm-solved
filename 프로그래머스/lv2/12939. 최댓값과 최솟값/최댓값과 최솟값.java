import java.util.*;
class Solution {
    public String solution(String s) {
        String[] str = s.split(" ");
        int max = Integer.parseInt(str[0]);
        int min = Integer.parseInt(str[0]);
        
        for (String x : str) {
            max = Math.max(max, Integer.parseInt(x));
            min = Math.min(min, Integer.parseInt(x));
        }
        
        String answer = min + " " + max;
        return answer;
    }
}