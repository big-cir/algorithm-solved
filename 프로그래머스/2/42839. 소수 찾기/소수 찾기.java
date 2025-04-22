import java.util.*;

class Solution {
    
    Set<Integer> answer; 
    
    public int solution(String numbers) {
        answer = new HashSet<>();
        int[] ch = new int[numbers.length()];
        search(0, "", numbers.toCharArray(), ch);
        return answer.size();
    }
    
    private void search(int depth, String proc, char[] chars, int[] ch) {
        if (depth > chars.length) return;
        if (depth > 0) {
            int num = Integer.parseInt(proc);
            if (isDecimal(num)) answer.add(num);
        }
        
        for (int i = 0; i < chars.length; i++) {
            if (ch[i] == 0) {
                ch[i] = 1;
                search(depth + 1, proc + chars[i], chars, ch);
                ch[i] = 0;
            }
        }
    }
    
    private boolean isDecimal(int num) {
        if (num == 1 || num == 0) return false;
        
        boolean flag = true;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return flag;
    }
}