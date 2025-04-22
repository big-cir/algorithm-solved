import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[][] solves = new int[3][];
        solves[0] = new int[] {1, 2, 3, 4, 5};
        solves[1] = new int[] {2, 1, 2, 3, 2, 4, 2, 5};
        solves[2] = new int[] {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int[] result = new int[3];
        int idx1 = 0;
        int idx2 = 0;
        int idx3 = 0;
        
        for (int x : answers) {
            if (x == solves[0][idx1]) result[0]++;
            if (x == solves[1][idx2]) result[1]++;
            if (x == solves[2][idx3]) result[2]++;
            
            idx1++;
            idx2++;
            idx3++;
            
            if (idx1 == solves[0].length) idx1 = 0;
            if (idx2 == solves[1].length) idx2 = 0;
            if (idx3 == solves[2].length) idx3 = 0;
        }
        
        int max = Arrays.stream(result).max().getAsInt();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < result.length; i++) {
            if (result[i] == max) list.add(i + 1);
        }
        
        int[] answer = new int[list.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}