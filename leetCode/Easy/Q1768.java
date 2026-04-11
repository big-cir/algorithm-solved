class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int w1Length = word1.length();
        int w2Length = word2.length();
        int idx1 = 0, idx2 = 0;
        while (idx1 < w1Length || idx2 < w2Length) {
            if (idx1 < w1Length) sb.append(word1.charAt(idx1++));
            if (idx2 < w2Length) sb.append(word2.charAt(idx2++));
        }

        return sb.toString();
    }
}
