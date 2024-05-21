import java.util.*;

class Solution {
    public int[] solution(int n, int s) {
        if (n > s) return new int[] {-1};
            
        // 12, 3 = (3, 4, 5), (4, 4, 4) 
        int[] answer = new int[n];
        int cnt = n;
        for (int i = 0; i < n; i++) {
            int shareNum = s / cnt--;
            answer[i] = shareNum;
            s -= shareNum;
        }
     
        return answer;
    }
}