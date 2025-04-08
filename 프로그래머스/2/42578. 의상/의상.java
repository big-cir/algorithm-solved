import java.util.*;

// 조합론: 0개 이상 n개 미만 선택하지 않는 경우의 수 (곱의 법칙)
//  -> 0...n개까지 선택 가능한 경우의 수 (n + 1)

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        for (String[] type : clothes) {
            map.put(type[1], map.getOrDefault(type[1], 0) + 1);
        }
        
        int answer = 1;
        for (String key : map.keySet()) {
            answer *= (map.get(key) + 1);
        }
    
        return answer - 1;
    }
}