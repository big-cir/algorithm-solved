class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        int idx = 0;

        for (char x : s.toCharArray()) {
            if (!Character.isAlphabetic(x)) {
                idx = 0;
                sb.append(x);
                continue;
            } else {
                if (idx % 2 == 0) {
                    sb.append(Character.toUpperCase(x));
                } else {
                    sb.append(Character.toLowerCase(x));
                }
            }
            idx++;
        }

        return sb.toString();
    }
}