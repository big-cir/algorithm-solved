class Solution {
    public String solution(String s) {
        String answer = s;

        if (answer.length() % 2 == 0) {
            int idx = answer.length() / 2;
            answer = answer.substring(idx - 1, idx + 1);
            return answer;
        } else {
            int idx = answer.length() / 2;
            answer = String.valueOf(answer.charAt(idx));
            return answer;
        }
    }
}