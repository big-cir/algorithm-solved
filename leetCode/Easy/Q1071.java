class Solution {
    public String gcdOfStrings(String str1, String str2) {
        String answer = "";
        int length = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str2.length(); i++) {
            sb.append(str2.charAt(i));
            String sub = sb.toString();

            if (isDivide(str1, sub) && isDivide(str2, sub)) {
                if (isGcd(str1, sub) && isGcd(str2, sub) && length < sub.length()) {
                    length = sub.length();
                    answer = sub;
                }
            }
        }

        return answer;
    }

    private boolean isDivide(String origin, String sub) {
        String result = origin.replace(sub, "");
        return result.length() == 0;
    }

    private boolean isGcd(String origin, String sub) {
        int subLength = sub.length();
        while (origin.length() != 0) {
            String comp = origin.substring(0, subLength);
            origin = origin.substring(subLength);
            if (!comp.equals(sub)) return false;
        }

        return true;
    }
}
