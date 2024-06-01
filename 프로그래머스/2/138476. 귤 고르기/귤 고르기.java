import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : tangerine) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        List<Integer> values = map.values().stream().sorted(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        }).collect(Collectors.toList());

        int answer = 0;
        for (int value : values) {
            answer++;
            k -= value;

            if (k <= 0) break;
        }
        
        return answer;
    }
}