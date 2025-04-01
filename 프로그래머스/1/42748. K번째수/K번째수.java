import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int n = commands.length;
        int[] answer = new int[n];
        
        for (int i = 0; i < n; i++) {
            int[] info = commands[i];
            int start = info[0] - 1;
            int end = info[1] - 1;
            int targetIndex = info[2] - 1;
            
            int[] cutArr = new int[end - start + 1];
            for (int j = 0; j < cutArr.length; j++) cutArr[j] = array[start++];
            Arrays.sort(cutArr);
            answer[i] = cutArr[targetIndex];
        }
        
        return answer;
    }
}