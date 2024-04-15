import java.util.*;

class Solution {
    
    static int answer = 0;
    static int[] visit;
    public int solution(String begin, String target, String[] words) {
        visit = new int[words.length];
        dfs(begin, target, words, 0);
        
        return answer;
    }
    
    private void dfs(String begin, String target, String[] words, int cnt) {
        if (begin.equals(target)) {
            answer = cnt;
            return;
        }
        
        for (int i = 0; i < words.length; i++) {
            if (visit[i] == 1) continue;
            
            String word = words[i];
            int size = begin.length();
            int matchCnt = size;;
            for (int j = 0; j < size; j++) {
                if (begin.charAt(j) == word.charAt(j)) matchCnt--;
            }
            
            if (matchCnt == 1) {
                visit[i] = 1;
                dfs(word, target, words, cnt + 1);
                visit[i] = 0;
            }
        }
    }
}