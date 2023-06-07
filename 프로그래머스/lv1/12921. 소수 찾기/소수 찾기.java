import java.util.*;

class Solution {
    public int solution(int n) {
        int answer = 0;
        int[] ch = new int[n + 1];
        
        for (int i = 2; i <= n; i++) {
            if (ch[i] == 0) answer++;
            for (int j = i; j <= n; j += i) {
                ch[j] = 1;
            }
        }
        
        return answer;
    }
}