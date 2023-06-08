import java.util.*;

class Solution {
    public long solution(long n) {
        List<String> list = new ArrayList<>();
        
        while (n > 0) {
            list.add(String.valueOf(n % 10));
            n /= 10;
        }
        
        Collections.sort(list, Collections.reverseOrder());
        
        String answer = "";
        for (String x : list) {
            answer += x;
        }
        
        return Long.parseLong(answer);
    }
}