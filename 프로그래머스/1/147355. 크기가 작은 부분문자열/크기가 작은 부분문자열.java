class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        if (t.length() < p.length()) return 0;
        
        int size = p.length();
        long pVal = stringToLong(p);
        for (int i = 0; i < t.length() - size + 1; i++) {
            long value = stringToLong(t.substring(i, i + size));
            if (pVal >= value) {
                answer++;
            }
        }
        return answer;
    }
    
    private int stringToInt(String str) {
        return Integer.parseInt(str);
    }
    
    private long stringToLong(String str) {
        return Long.parseLong(str);
    }
}