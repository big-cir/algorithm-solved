class Solution {
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();
        char[] ch = s.toCharArray();

        for (int i = 0; i < s.length(); i++) {
            if (!Character.isAlphabetic(ch[i])) {
                sb.append(ch[i]);
            } else if (Character.isLowerCase(ch[i])) {
                int tmp = (ch[i] + n);
                if (tmp > 'z') {
                    ch[i] = 'a';
                    int gap = tmp - 'z';
                    tmp = (ch[i] + gap - 1);
                }
                sb.append((char) tmp);
            } else if (Character.isUpperCase(ch[i])){
                int tmp = ch[i] + n;
                if (tmp > 'Z') {
                    ch[i] = 'A';
                    int gap = tmp - 'Z';
                    tmp = (ch[i] + gap - 1);
                }
                sb.append((char)tmp);
            }
        }

        String answer = sb.toString();
        return answer;
    }
}