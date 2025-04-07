import java.util.*;

class Solution {
    public int solution(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : nums) map.put(x, map.getOrDefault(x, 0) + 1);
        List<Integer> list = new ArrayList<>(map.values());
        Collections.sort(list, Collections.reverseOrder());
        
        int answer = 0;
        int pick = nums.length / 2;
        for (int x : list) {
            if (pick > 0) {
                answer++;
                pick--;
            } else break;
        }
        
        return answer;
    }
}