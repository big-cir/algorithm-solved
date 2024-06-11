import java.util.*;

class Solution {
    
    class Word {
        private String str;
        private int step;
        
        public Word(String str, int step) {
            this.str = str;
            this.step = step;
        }
    }
    
    public int solution(String begin, String target, String[] words) {
        int answer = bfs(begin, target, words);
        return answer == Integer.MAX_VALUE ? 0 : answer;
    }
    
    private int bfs(String begin, String target, String[] words) {
        int min = Integer.MAX_VALUE;
        int[] ch = new int[words.length];
        
        Queue<Word> queue = new LinkedList<>();
        queue.offer(new Word(begin, 0));
        
        while (!queue.isEmpty()) {
            Word now = queue.poll();
            
            if (now.str.equals(target)) {
                min = Math.min(min, now.step);
                continue;
            }
            
            // 1. 단어 하나를 바꿔 포함되는지
            // 2. 이미 바꾼건지
            for (int i = 0; i < words.length; i++) {
                if (ch[i] == 1) continue;
                
                String comp = words[i];
                int another = 0;
                for (int j = 0; j < comp.length(); j++) {
                    if (now.str.charAt(j) != comp.charAt(j)) another++;
                }
                
                if (another == 1) {
                    ch[i] = 1;
                    queue.offer(new Word(comp, now.step + 1));
                }
            }
        }
        
        return min;
    }
}