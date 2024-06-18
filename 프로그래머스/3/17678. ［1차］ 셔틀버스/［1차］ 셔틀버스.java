import java.util.*;

class Solution {
    // n 회
    // t 분 간격
    // 최대 m 명
    public String solution(int n, int t, int m, String[] timetable) {
        Queue<Integer> pq = new PriorityQueue<>();
        for (String crew : timetable) {
            pq.offer(getM(crew));
        }

        int def = 540;
        int answer = 0;
        int[] bus = new int[n];
        for (int i = 0; i < n; i++) {
            while (!pq.isEmpty() && bus[i] < m) {
                int now = pq.poll();
                
                if (now <= def) {
                    bus[i]++;
                    answer = now - 1;
                } else {
                    pq.offer(now);
                    break;
                }
            }
            
            def += t;
        }
        
        if (bus[n - 1] < m) answer = def - t;
        return String.format("%02d", answer / 60) + ":" + String.format("%02d", answer % 60);
    }
    
    private int getM(String str) {
        String[] info = str.split(":");
        return Integer.parseInt(info[0]) * 60 + Integer.parseInt(info[1]);
    }
}