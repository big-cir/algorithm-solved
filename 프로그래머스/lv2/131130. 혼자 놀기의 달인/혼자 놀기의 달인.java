import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
class Solution {
    
    public static void sol(int x, List<Integer> box, List<Integer> length, int[] ch, int[] cards) {
        int idx = x;
        for (int i = x; i < cards.length + 1; i++) {
            int cur = cards[idx];

            if (ch[idx] == 0) {
                ch[idx] = 1;
                box.add(cur);
                idx = cur - 1;
            } else {
                length.add(box.size());
                box.clear();
            }
        }
    }
    
    public int solution(int[] cards) {
        int answer = 1;
        List<Integer> box = new ArrayList<>();
        List<Integer> length = new ArrayList<>();
        int[] ch = new int[cards.length];

        // int idx = 0;
        for (int i = 0; i < cards.length; i++) {
            sol(i, box, length, ch, cards);
        }
        
        Collections.sort(length, Collections.reverseOrder());
        if (length.size() < 2) answer = 0;
        else {
            answer *= length.get(0) * length.get(1);
        }
        return answer;
    }
}