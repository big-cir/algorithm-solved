import java.util.*;

class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int day = 0;
        int answer = 0;
        for (int i = 0; i < schedules.length; i++) {
            int hope = schedules[i];
            day = startday;
            boolean flag = true;
            for (int j = 0; j < 7; j++) {
                if (day % 7 == 6 || day % 7 == 0) {
                    if (day == 7) day = 0;
                    day++;
                    continue;
                }
                
                if (!valid(hope, timelogs[i][j])) {
                    flag = false;
                    break;
                }
                
                day++;
            }
            
            if (flag) {
                answer++;
            }
        }
        
        return answer;
    }
    
    private static boolean valid(int hope, int enter) {
        if (hope % 100 + 10 >= 60) {
            int minute = (hope + 10) % 100 - 60;
            int time = ((hope / 100) + 1) * 100;
            time += minute;
            
            return enter <= time;
        }
        
        return enter <= hope + 10;
    }
}