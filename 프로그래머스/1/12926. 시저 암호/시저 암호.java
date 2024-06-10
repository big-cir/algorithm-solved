class Solution {
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();
        
        for (char x : s.toCharArray()) {
            if (Character.isLowerCase(x)) {
                int val = x + n;
                
                if (val > 'z') {
                    val -= 26;
                }
                sb.append((char) val);
                continue;
            }
            
            if (Character.isUpperCase(x)) {
                int val = x + n;
                
                if (val > 'Z') {
                    val -= 26;
                }
                sb.append((char) val);
                continue;
            }
            
            if (!Character.isAlphabetic(x)) {
                sb.append(x);
            }
        }
        
        return sb.toString();
    }
}