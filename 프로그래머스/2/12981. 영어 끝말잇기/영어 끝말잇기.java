import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int num = 1;
        int turn = 1;
        
        Set<String> set = new HashSet<>();
        String cur = words[0];
        set.add(cur);
        for (int i = 1; i < words.length; i++) {
            num++;
            if (num > n) {
                num = 1;
                turn++;
            }
            
            String next = words[i];
            
            if (set.contains(next) ||
               cur.charAt(cur.length() - 1) != next.charAt(0)) break;
            
            cur = next;
            set.add(next);
        }
        
        if (cur.equals(words[words.length - 1])) return new int[] {0, 0,};
        return new int[] {num, turn};
    }
}