// sol1: stack O(n + m) & O(n + m)
class Solution {
    public boolean backspaceCompare(String s, String t) {
        Deque<Character> sd = new ArrayDeque<>();
        Deque<Character> td = new ArrayDeque<>();
        for (char ch : s.toCharArray()) {
            if (ch == '#') {
                sd.pollLast();
            } else {
                sd.offer(ch);
            }
        }

        for (char ch : t.toCharArray()) {
            if (ch == '#') {
                td.pollLast();
            } else {
                td.offer(ch);
            }
        }

        if (sd.size() != td.size()) return false;

        while (!sd.isEmpty()) {
            if (sd.pollLast() != td.pollLast()) return false;
        }

        return true;
    }
}

// sol2: two pointer O(n + m) & O(1)
class Solution {
    public boolean backspaceCompare(String s, String t) {
        int sIdx = s.length() - 1, tIdx = t.length() - 1;
        int skipS = 0, skipT = 0;

        while (sIdx >= 0 || tIdx >= 0) {
            while (sIdx >= 0) {
                if (s.charAt(sIdx) == '#') {
                    sIdx--;
                    skipS++;
                } else if (skipS > 0) {
                    sIdx--;
                    skipS--;
                } else {
                    break;
                }
            }

            while (tIdx >= 0) {
                if (t.charAt(tIdx) == '#') {
                    tIdx--;
                    skipT++;
                } else if (skipT > 0) {
                    tIdx--;
                    skipT--;
                } else {
                    break;
                }
            }

            if (sIdx >= 0 && tIdx >= 0 && s.charAt(sIdx) != t.charAt(tIdx)) return false;
            if ((sIdx >= 0) != (tIdx >= 0)) return false;

            sIdx--;
            tIdx--;
        }

        return true;
    }
}
