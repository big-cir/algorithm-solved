class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int length1 = s1.length();
        int length2 = s2.length();
        int[] result = new int[26];
        for (int i = 0; i < length1; i++) {
            char ch = s1.charAt(i);
            result[ch - 97]++;
        }

        for (int i = 0; i < length2; i++) {
            char ch = s2.charAt(i);
            result[ch - 97]--;

            if (i >= length1) {
                char previous = s2.charAt(i - length1);
                result[previous - 97]++;
            }

            boolean flag = true;
            for (int x : result) {
                if (x != 0) {
                    flag = false;
                    break;
                }
            }

            if (flag) return true;
        }

        return false;
    }
}
