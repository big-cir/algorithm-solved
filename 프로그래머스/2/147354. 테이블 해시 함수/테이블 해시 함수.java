import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        Arrays.sort(data, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[col - 1] == o2[col - 1]) return o2[0] - o1[0];
                return o1[col - 1] - o2[col - 1];
            }
        });
        
        int answer = 0;
        for (int i = row_begin; i <= row_end; i++) {
            int[] record = data[i - 1];
            int tmp = 0;
            for (int x : record) {
                tmp += (x % i);
            }
            answer ^= tmp;
        }
        
        return answer;
    }
}