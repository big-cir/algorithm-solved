import java.util.HashMap;
import java.util.Map;
class Solution {
    static Map<String, Integer> map = new HashMap<>();

    public int solution(String s) {
        map.put("zero", 0);
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        map.put("four", 4);
        map.put("five", 5);
        map.put("six", 6);
        map.put("seven", 7);
        map.put("eight", 8);
        map.put("nine", 9);

        for (String key : map.keySet()) {
            s = s.replace(key, String.valueOf(map.get(key)));
        }

        return Integer.parseInt(s);
    }
}