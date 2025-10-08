import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        Map<String, Integer> userIdx = new HashMap<>();
        Map<String, Integer> give = new HashMap<>();
        Map<String, Integer> receive = new HashMap<>();
        Map<String, Integer> result = new HashMap<>();
        int idx = 0;
        for (String x : friends) {
            give.put(x, 0);
            receive.put(x, 0);
            result.put(x, 0);
            userIdx.put(x, idx++);
        }
        
        int size = result.size();
        int[][] grResult = new int[size][size];
        for (String gift : gifts) {
            String[] strs = gift.split(" ");
            String g = strs[0];
            String r = strs[1];
            give.put(g, give.getOrDefault(g, 0) + 1);
            receive.put(r, receive.getOrDefault(r, 0) + 1);
            
            int gIdx = userIdx.get(g);
            int rIdx = userIdx.get(r);
            grResult[gIdx][rIdx]++;
        }
        
        for (String x : friends) {
            result.put(x, give.get(x) - receive.get(x));
        }
        
        int max = 0;
        for (String x: friends) {
            int score = result.get(x);
            int cnt = 0;
            int gIdx = userIdx.get(x);
            for (String y : friends) {
                if (x.equals(y)) continue;
                
                int rIdx = userIdx.get(y);
                int s1 = grResult[gIdx][rIdx];
                int s2 = grResult[rIdx][gIdx];
                if (s1 > s2) cnt++;
                else {
                    if ((s1 == 0 && s1 == s2) || (s1 == s2)) {
                        if (score > result.get(y)) cnt++;
                    }
                }
            }
            max = Math.max(max, cnt);
        }
        
        return max;
    }
}