import java.util.*;

class Solution {

    public static String[] solution(String[] players, String[] callings) {
        Map<String, Integer> after = new HashMap<>();
        Map<Integer, String> before = new HashMap<>();

        for (int i = 1; i <= players.length; i++) {
            after.put(players[i - 1], i);
            before.put(i, players[i - 1]);
        }

        for (int i = 1; i <= callings.length; i++) {
            String call = callings[i - 1];

            int oIdx = after.get(call);
            String ch = before.get(oIdx - 1);
            after.put(before.get(oIdx - 1), oIdx);
            after.put(before.get(oIdx), oIdx - 1);

            before.put(oIdx, ch);
            before.put(oIdx - 1, call);
        }

        String[] answer = new String[players.length];
        for (int i = 1; i <= players.length; i++) {
            answer[i - 1] = before.get(i);
        }

        return answer;
    }
}

// 50000 * 10000000 O(N^2) x
// hash 