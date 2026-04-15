class Solution {
    public int compress(char[] chars) {
        StringBuilder sb = new StringBuilder();
        char prev = chars[0];
        int cnt = 1;
        for (int i = 1; i < chars.length; i++) {
            char comp = chars[i];
            if (prev == comp) {
                cnt++;
            } else {
                sb.append(prev);
                if (cnt != 1) sb.append(cnt);
                cnt = 1;
            }

            prev = comp;
        }

        sb.append(prev);
        if (cnt != 1) sb.append(cnt);

        int length = sb.toString().length();
        for (int i = 0; i < length; i++) {
            chars[i] = sb.charAt(i);
        }
        
        return length;
    }
}
