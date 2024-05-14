import java.util.*;

class Solution {
    public int solution(int[] cards) {
        int answer = 0;
        int[] ch = new int[cards.length];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < cards.length; i++) {
            if (ch[i] == 1) continue;
            
            ch[i] = 1;
            int size = 1;
            int idx = cards[i] - 1;
            while (ch[idx] == 0) {
                ch[idx] = 1;
                size++;
                idx = cards[idx] - 1;
            }
            list.add(size);
        }
        
        Collections.sort(list, Collections.reverseOrder());
        if (list.size() != 1) {
            answer = list.get(0) * list.get(1);
        }
        return answer;
    }
}
// [1, 4, 7, 8], [2, 5, 6], [3]