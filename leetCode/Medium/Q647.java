class Solution {
    public int countSubstrings(String s) {
        if (s.length() == 1) return 1;

        int n = s.length();
        int answer = n;
        for (int i = 0; i < n; i++) {
            int lt = i - 1, rt = i + 1;
            answer += palinResult(lt, rt, s);
        }

        for (int i = 0; i < n - 1; i++) {
            int lt = i, rt = i + 1;            
            answer += palinResult(lt, rt, s);
        }

        return answer;
    }

    private int palinResult(int lt, int rt, String s) {
        int result = 0;
        while (lt >= 0 && rt < s.length()) {
            if (s.charAt(lt) == s.charAt(rt)) {
                result++;
            } else break;
            lt--;
            rt++;
        }

        return result;
    }
}
