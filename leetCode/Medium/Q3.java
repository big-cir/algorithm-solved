class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] arr = new int[128];
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        int lt = 0, rt = 0;
        while (rt != s.length()) {
            char ch = s.charAt(rt);
            if (arr[ch] == 0) {
                sb.append(ch);
                answer = Math.max(answer, sb.toString().length());
                rt++;
                arr[ch]++;
            } else {
                while (arr[ch] != 0) {
                    char previous = s.charAt(lt++);
                    arr[previous]--;
                    sb.deleteCharAt(0);
                }
            }
        }

        return answer;
    }
}
