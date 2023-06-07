import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        String input = String.valueOf(n);

        for (int i = 0; i < input.length(); i++) {
            answer = answer + input.charAt(i) - 48;
        }

        return answer;
    }
}