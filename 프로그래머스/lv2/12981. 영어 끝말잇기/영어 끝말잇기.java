import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int[] solution(int n, String[] words) {
        int idx = 1;
        int seq = 1;
        boolean flag = true;
        Set<String> word = new HashSet<>();
        word.add(words[0]);

        for (int i = 1; i < words.length; i++) {
            String x = words[i];
            idx++;
            if (idx == n + 1) {
                idx = 1;
                seq++;
            }

            if (!word.contains(x)) {
                if (words[i - 1].charAt(words[i - 1].length() - 1) != x.charAt(0)) {
                    flag = false;
                    break;
                }
                word.add(x);
            } else {
                flag = false;
                break;
            }
        }

        if (flag) {
            idx = 0;
            seq = 0;
        }

        return new int[] {idx, seq};
    }
}