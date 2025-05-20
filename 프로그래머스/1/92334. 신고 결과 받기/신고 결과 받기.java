import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int n = id_list.length;
        Map<String, Integer> reportResult = new HashMap<>();
        Map<String, List<String>> reportStatus = new HashMap<>();
        for (String id : id_list) {
            reportResult.put(id, 0);
            reportStatus.put(id, new ArrayList<>());
        }
        
        Set<String> targets = new HashSet<>();
        for (String r : report) {
            String[] info = r.split(" ");
            String id = info[0];
            String target = info[1];
            
            if (!reportStatus.get(id).contains(target)) {
                reportResult.put(target, reportResult.get(target) + 1);
                reportStatus.get(id).add(target);   
            }
            
            if (reportResult.get(target) >= k) {
                targets.add(target);
            }
        }
        
        int[] answer = new int[n];
        for (int i = 0; i < id_list.length; i++) {
            String id = id_list[i];
            
            for (String target : targets) {
                if (reportStatus.get(id).contains(target)) answer[i]++;
            }
        }
        
        return answer;
    }
}