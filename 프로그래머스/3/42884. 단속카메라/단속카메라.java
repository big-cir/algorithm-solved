import java.util.*;

// [-20, -15], [-18, -13], [-14, -5], [-5, -3]
class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        int answer = 0;
        int camera = -30001;
        for (int[] route : routes) {
            if (route[0] > camera || route[1] < camera) {
                answer++;
                camera = route[1];
            }
        }
        
        return answer;
    }
}