
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Collections;

class Solution {
    // 시간복잡도 = orders.length * course.length * 2^order.length
    // --> O(20 * 10 * 2^10)
    // AC CA 동일
    static Map<String, Integer> map;
    public String[] solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<>();
        map = new HashMap<>();
        
        for (String order : orders) {
            order = sortStr(order);
            for (int cnt : course) {
                combi(0, cnt, "", order, 0);
            }
        }

        int[] maxCnt = new int[course.length];

        for (int i = 0; i < course.length; i++) {
            for (String key : map.keySet()) {
                int value = map.get(key);
                if (key.length() == course[i]) {
                    maxCnt[i] = Math.max(maxCnt[i], value);
                }
            }
        }

        for (int i = 0; i < maxCnt.length; i++) {
            if (maxCnt[i] < 2) continue;
            for (String key : map.keySet()) {
                int value = map.get(key);
                if (value == maxCnt[i] && key.length() == course[i]) {
                    answer.add(key);
                }
            }
        }

        Collections.sort(answer);
        return answer.toArray(new String[0]);
    }

    private void combi(int level, int course, String menu, String order, int start) {
        if (level == course) {
            map.put(menu, map.getOrDefault(menu, 0) + 1);
            return;
        }

        for (int i = start; i < order.length(); i++) {
            String next = String.valueOf(order.charAt(i));
            combi(level + 1, course, menu + next, order, i + 1);
        }
    }
    
    private static String sortStr(String str) {
        char[] charArr = str.toCharArray();
        Arrays.sort(charArr);
        return String.valueOf(charArr);
    }
}