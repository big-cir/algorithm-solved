import java.util.*;
class Solution {
    
    public static int count(String 이진수) {
        int count = 0;
        char[] chars = 이진수.toCharArray();
        for (char x : chars) {
            if (x == '1') {
                count++;
            }
        }
        return count;
    }
    
    public int solution(int n) {
        int oneNum = count(Integer.toBinaryString(n));
        
        int minNum = n + 1;
        while (true) {
            String find = Integer.toBinaryString(minNum);
            if (oneNum == count(find)) {
                break;
            } else {
                minNum++;
            }
        }
        return minNum;
    }
}