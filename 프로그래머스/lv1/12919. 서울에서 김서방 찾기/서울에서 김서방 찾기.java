class Solution {
    public String solution(String[] seoul) {
        int location = 0;
        String answer = "김서방은 ";
        
        for (int i = 0; i < seoul.length; i++) {
            if (seoul[i].equals("Kim")) break;
            location++;
        }
        
        answer = answer + location + "에 " + "있다";
        return answer;
    }
}