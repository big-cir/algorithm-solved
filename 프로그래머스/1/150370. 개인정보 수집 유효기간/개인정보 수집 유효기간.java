import java.util.*;

class Solution {
    
    static List<Integer> answer;
    static Map<String, Integer> term;
    
    public int[] solution(String today, String[] terms, String[] privacies) {
        term = new HashMap<>();
        for (String str : terms) {
            String[] arr = str.split(" ");
            term.put(arr[0], Integer.parseInt(arr[1]));
        }
        
        today = today.replaceAll("\\.", "");
        int todayValue = Integer.parseInt(today);
        
        int idx = 1;
        answer = new ArrayList<>();
        for (String str : privacies) {
            String[] info = str.split(" ");
            String day = info[0];
            String type = info[1];
            String[] dayInfo = day.split("\\.");
            
            int y = Integer.parseInt(dayInfo[0]);
            int m = Integer.parseInt(dayInfo[1]);
            int d = Integer.parseInt(dayInfo[2]);
            
            String expired = "";
            
            d--;
            if (d == 0) {
                d = 28;
                m--;
                
                if (m == 0) {
                    m = 12;
                    y--;
                }
            }
            
            m += term.get(type);
            if (m > 12) {
                while (m > 12) {
                    m -= 12;
                    y++;
                }
            }
            
            expired += y;
            
            if (m < 10) expired += "0" + m;
            else expired += m;
            
            if (d < 10) expired +="0" + d;
            else expired += d;
            
            int expiredValue = Integer.parseInt(expired);
            if (expiredValue < todayValue) answer.add(idx);
            idx++;
        }
        
        return answer.stream().mapToInt(x -> x).toArray();
    }
}