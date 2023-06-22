class Solution {
    public String solution(String s) {
        String answer = "";
        String[] str = s.toLowerCase().split(" ");

        for (String x : str) {
            if (x.length() == 0) {
                answer += " ";
            } else {
                String f = x.substring(0, 1).toUpperCase();
                String e = x.substring(1, x.length());
                answer += f + e + " ";
            }
        }

        if (s.substring(s.length() - 1, s.length()).equals(" ")) answer += " ";

        return answer.substring(0, answer.length() - 1);
    }
}