class Solution {
    public String solution(String number, int k) {
        String answer = "";
        String[] str = number.split("");
        int idx = 0;
        
        for (int i = 0; i < number.length() - k; i++) {
            int digit = 0;
            // 0 + 2
            for (int j = idx; j <= i + k; j++) {
                if (digit < Integer.parseInt(str[j])) {
                    digit = Integer.parseInt(str[j]);
                    idx = j + 1;
                }
                if (digit == 9) break;
            }
            answer += digit;
        }
        return answer;
    }
}