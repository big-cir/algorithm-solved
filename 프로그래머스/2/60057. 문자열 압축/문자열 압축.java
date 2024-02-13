class Solution {
    public int solution(String s) {
        int answer = Integer.MAX_VALUE;
        char[] chars = s.toCharArray();
        for (int i = 1; i <= s.length(); i++) {
            answer = Math.min(answer, subset(i, chars).length());
        }
        return answer;
    }
    
    public String subset(int splitCount, char[] chars) {
        StringBuilder sb = new StringBuilder();
        String str = "";
        int cnt = 1;
        for (int i = 0; i < splitCount; i++) {
            str += chars[i];
        }

        for (int i = splitCount; i < chars.length; i += splitCount) {
            String str2 = String.valueOf(makeStr(chars, i, i + splitCount));
            if (str2.equals(str)) {
                cnt++;
            } else {
                if (cnt == 1) {
                    sb.append(str);
                } else {
                    sb.append(cnt + str);
                }
                cnt = 1;
                str = str2;
            }
        }

        if (cnt == 1) {
            sb.append(str);
        } else {
            sb.append(cnt + str);
        }

        return sb.toString();
    }

    public String makeStr(char[] chars, int start, int end) {
        String tmp = "";
        if (end > chars.length) end = chars.length;
        for (int i = start; i < end; i++) {
            tmp += chars[i];
        }
        return tmp;
    }
}