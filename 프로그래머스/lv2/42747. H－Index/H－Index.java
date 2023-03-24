import java.util.*;
class Solution {
    public static boolean isCitatios(int[] citations, int h) {
        int idx = citations.length - h;  
        return citations[idx] >= h;

    }

    public int solution(int[] citations) {
        Arrays.sort(citations); // 0, 1, 3, 5, 6
        for (int i = citations.length; i >= 1; i--) {
            if (isCitatios(citations, i)) return i;
        }

        return 0;
    }
}