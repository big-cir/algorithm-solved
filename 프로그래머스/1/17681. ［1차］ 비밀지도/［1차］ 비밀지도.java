import java.util.Arrays;
class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for (int i = 0; i < n; i++) {
            String map1 = toBinary(n, arr1[i]);
            String map2 = toBinary(n, arr2[i]);
            String tmp = "";
            for (int j = 0; j < n; j++) {
                if (map1.charAt(j) == '1' || map2.charAt(j) == '1') {
                    tmp += "1";
                } else {
                    tmp += "0";
                }
                answer[i] = tmp;
            }
        }
        
        for (int i = 0; i < n; i++) {
            answer[i] = toCipher(answer[i].split(""));
        }
        
    
        return answer;
    }
    
    // 1은 #, 0은 공백으로 변경
    private String toCipher(String[] sub) {
        String tmp = "";
        for (int i = 0; i < sub.length; i++) {
            if (sub[i].equals("1")) {
                tmp += "#";
            } else {
                tmp += " ";
            }
        }
        return tmp;
    }
    
    // 배열에 있는 값을 2진수로 변경
    private String toBinary(int n, int value) {
        StringBuilder sb = new StringBuilder();
        while(value > 0) {
            sb.append(value % 2);
            value /= 2;
        }
        
        if (sb.length() < n) {
            for (int i = sb.length(); i < n; i++) {
                sb.append("0");
            }
        }
        return sb.reverse().toString();
    }
}