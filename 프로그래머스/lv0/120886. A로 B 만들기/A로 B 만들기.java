import java.util.*;
class Solution {
    public static Map<Character, Integer> toMap(String words) {
        Map<Character, Integer> map = new HashMap<>();

        for (char c : words.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        return map;
    }

    public int solution(String before, String after) {
        return toMap(before).equals(toMap(after)) ? 1 : 0;
    }
}