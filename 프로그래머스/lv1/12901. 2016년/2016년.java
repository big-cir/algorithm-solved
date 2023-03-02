import java.util.*;
class Solution {
    public String solution(int a, int b) {
        String answer = "";
        // 2016-01-01은 금요일
        String[] str = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
        int[] A = new int[]{0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        int total_date = -1;
        for (int i = 1; i < a; i++) {
            total_date += A[i];
        }

        //
        int yoil = (total_date + b) % 7;
        answer = str[yoil];
        return answer;
    }
}