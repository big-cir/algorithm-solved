class Solution {
    public boolean isPalindrome(String s) {
        s = s.trim();
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) sb.append(Character.toLowerCase(c));
        }

        String origin = sb.toString();
        sb.reverse();
        String reverse = sb.toString();
    
        return origin.equals(reverse);
    }
}
