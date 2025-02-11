import java.util.*;

class Solution {
    
    static int answer;
    static Set<Integer> set;
    
    public int solution(int n, int[][] q, int[] ans) {
        answer = 0;
        set = new HashSet<>();
        recur(0, n, 1, q, ans);
        return answer;
    }
    
    private void recur(int depth, int n, int num, int[][] q, int[] ans) {
        if (depth == 5) {
            boolean flag = true;
            int[] compArr = new int[ans.length];
            for (int i = 0; i < q.length; i++) {
                for (int j = 0; j < 5; j++) {
                    if (set.contains(q[i][j])) {
                        compArr[i]++;
                    }
                }
                
                if (ans[i] != compArr[i]) {
                    flag = false;
                    break;
                }
            }
            
            if (flag) answer++;
            return;
        }
        
        for (int i = num; i <= n; i++) {
            if (depth == 0 && num >= 6) continue;
            
            if (!set.contains(i)) {
                set.add(i);
                recur(depth + 1, n, i + 1, q, ans);
                set.remove(i);
            }
        }
    }
}