import java.util.*;

// ["2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"]
class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < terms.length; i++) {
            String term = terms[i];
            String[] strs = term.split(" ");
            map.put(strs[0], Integer.parseInt(strs[1]));
        }
        
        List<Integer> result = new ArrayList<>();
        int[] numsToday = numsDate(today);
        String comp1 = getDate(numsToday);
        for (int i = 0; i < privacies.length; i++) {
            String privacy = privacies[i];
            String[] dateRuleStrs = privacy.split(" ");
            int[] startDate = numsDate(dateRuleStrs[0]);
            int ruleMonth = map.get(dateRuleStrs[1]);
            
            int expiredYear = startDate[0] + ruleMonth / 12;
            int expiredMonth = startDate[1] + ruleMonth % 12;
            int expiredDay = startDate[2] - 1;
            
            if (expiredDay == 0) {
                expiredMonth -= 1;
                expiredDay = 28;
                
                if (expiredMonth == 0) {
                    expiredYear -= 1;
                    expiredMonth = 12;
                } 
            }
            
            if (expiredMonth >= 13) {
                expiredMonth = expiredMonth - 12;
                expiredYear += 1;
            }
            
            int[] expiredDate = new int[] {expiredYear, expiredMonth, expiredDay};
            String comp2 = getDate(expiredDate);
            if (Integer.parseInt(comp2) < Integer.parseInt(comp1)) result.add(i + 1);
        }
        
        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) answer[i] = result.get(i);
        return answer;
    }
    
    private int[] numsDate(String today) {
        String[] strs = today.split("\\.");
        int[] nums = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            nums[i] = Integer.parseInt(strs[i]);
        }
        
        return nums;
    }
    
    private String getDate(int[] date) {
        String strDate = String.valueOf(date[0]);
        
        if (date[1] < 10) strDate += ("0" + date[1]);
        else strDate += date[1];
        
        if (date[2] < 10) strDate += ("0" + date[2]);
        else strDate += date[2];
                                      
        return strDate;
    }
}