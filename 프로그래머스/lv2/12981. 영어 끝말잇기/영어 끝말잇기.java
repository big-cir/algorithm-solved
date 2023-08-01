import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int[] solution(int n, String[] words) {
        int 번호 = 1;
        int 차례 = 1;

        boolean flag = true;
        int pos = 0;
        Set<String> set = new HashSet<>();
        set.add(words[pos++]);
        
        while (pos < words.length) {
            번호++;
            if (번호 == n + 1) {
                번호 = 1;
                차례++;
            }
            
            if (!set.contains(words[pos])) {
                if (words[pos - 1].charAt(words[pos - 1].length() - 1) != words[pos].charAt(0)) {
                    flag = false;
                    break;
                }
                set.add(words[pos]);
            } else {
                flag = false;
                break;
            }
            
            pos++;
        }
        
        if (flag) {
            번호 = 0;
            차례 = 0;
        }
        
        return new int[] {번호, 차례};
    }
}